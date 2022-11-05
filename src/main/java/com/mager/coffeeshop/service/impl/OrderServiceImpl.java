package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.dto.CustomerOrderInfo;
import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.OrderDetail;
import com.mager.coffeeshop.entity.OrderStatus;
import com.mager.coffeeshop.entity.OrderUserinfo;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.OrdersRepository;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.LocationService;
import com.mager.coffeeshop.service.OrderService;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger("OrderService");
    private static final String SQL_GET_ALL_ORDERS = "select o from Order o where o.location.id = :id " +
            "and o.orderDateTime > :orderDateTime and o.orderStatus = :orderStatus  order by o.orderDateTime";
    private static final String SQL_ORDERINFO_IS_EXIST = "select (count(o) > 0) from OrderUserinfo o where o.phone = :phone and o.name = :name";
    private static final String SQL_SELECT_ORDERINFO_BY_NAME_AND_PHONE = "select o from OrderUserinfo o where o.phone = :phone and o.name = :name";
    private static final int PAGE_SIZE = 10;
    private final CartService cartService;
    private final UserService userService;
    private final OrdersRepository ordersRepository;
    private final ProductService productService;
    private final LocationService locationService;

    @PersistenceContext
    private EntityManager entityManager;

    public OrderServiceImpl(CartService cartService,
                            UserService userService, OrdersRepository ordersRepository,
                            ProductService productService, LocationService locationService) {
        this.cartService = cartService;
        this.userService = userService;
        this.ordersRepository = ordersRepository;
        this.productService = productService;
        this.locationService = locationService;
    }


    @Override
    public Page<Order> getUserOrders(Principal principal, int page) {
        Order order = new Order();
//        User user = userService.getUserByPrincipal(principal);
        User user = userService.getUserFromSecurityContext();
        order.setUser(user);
        Example<Order> example = Example.of(order,
                ExampleMatcher
                        .matching()
                        .withIgnoreNullValues());
        return ordersRepository.findAll(example,
                PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "orderDateTime")));
    }


    @Override
    public Page<Order> getOrders(Long locationId, Integer page, String orderStatus) {
        List<Order> orderList = getAllOrderListFromDB(locationId, orderStatus);
        int size = PAGE_SIZE;
        int end = Math.min((page * size + size), orderList.size());
        PageRequest pageRequest = PageRequest.of(page, size);
        List<Order> orders = orderList.subList(Math.toIntExact(pageRequest.getOffset()), end);
        Page<Order> orderPage = new PageImpl<>(orders, pageRequest, orderList.size());
        return orderPage;
    }

    private List<Order> getAllOrderListFromDB(Long locationId, String orderStatus) {
        TypedQuery<Order> query = entityManager.createQuery(SQL_GET_ALL_ORDERS, Order.class);
        query.setParameter("id", locationId);
        query.setParameter("orderDateTime", Timestamp.valueOf(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIN)));
        Optional<OrderStatus> orderStatusOptional = Arrays.stream(OrderStatus.values()).filter(status -> status.name().equals(orderStatus)).findFirst();
        query.setParameter("orderStatus", orderStatusOptional.orElse(OrderStatus.NEW));
        return query.getResultList();
    }


    @Override
    public Map<OrderDetail, Product> getOrderDetails(Order order) {
        order = ordersRepository.getReferenceById(order.getId());
        return order.getOrderDetails().stream()
                .collect(Collectors.toMap(
                        orderDetail -> orderDetail,
                        orderDetail -> productService.getById(new ObjectId(orderDetail.getProductId()))));
    }

    @Override
    public Order getOrder(Order order) {
        return ordersRepository.getReferenceById(order.getId());
    }

    @Override
    public Order getOrderById(Long orderId) {
        return ordersRepository.getReferenceById(orderId);
    }

    @Override
    public void changeDiscount(Order updateOrder) {
        Integer newDiscount = updateOrder.getDiscount();
        Order order = ordersRepository.getReferenceById(updateOrder.getId());
        order.setDiscount(newDiscount);
        ordersRepository.save(order);
    }

    @Override
    public void changeStatus(Order updateOrder) {
        if (ordersRepository.existsById(updateOrder.getId())) {
            Order order = ordersRepository.getReferenceById(updateOrder.getId());
            order.setOrderStatus(updateOrder.getOrderStatus());
            ordersRepository.save(order);
        }
    }

    @Override
    public void doOrder(CustomerOrderInfo customerOrderInfo) {
        ordersRepository.save(this.createNewOrder(customerOrderInfo));
        cartService.cleanUserCart();
    }

    @Override
    public boolean isOrderExist(Long orderId) {
        return ordersRepository.existsById(orderId);
    }

    private Order createNewOrder(CustomerOrderInfo customerOrderInfo) {
        Map<Product, Integer> customerCart = cartService.getUserProductCart();
        Order order = this.convertCartToOrder(customerCart);
        this.setCustomerDataToOrder(order, customerOrderInfo);
        return order;
    }

/*
    private void setOrderLocation(Order order, long locationId) {
        order.setLocation(locationService.getLocation(locationId));
    }*/

    private void setCustomerDataToOrder(Order order, CustomerOrderInfo customerOrderInfo) {
        User user = userService.getUserByUUID(userService.getCustomerUUID());
        OrderUserinfo orderUserinfo = this.createUserInfo(customerOrderInfo);
        orderUserinfo.getOrders().add(order);
        order.setOrderUserinfo(orderUserinfo);
        order.setDiscount(user.getDiscount());
        order.setLocation(locationService.getLocation(customerOrderInfo.getLocationId()));
        order.setUser(user);
    }

    private void calculateAndSetTotalCost(Order order) {
        order.getOrderDetails().forEach(orderDetail -> orderDetail.setOrder(order));
        BigDecimal totalOrderCost = order.getOrderDetails().stream()
                .map(orderDetail ->
                        orderDetail.getProductCost().multiply(BigDecimal.valueOf(orderDetail.getProductCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setCost(totalOrderCost);
    }

    private Order convertCartToOrder(Map<Product, Integer> cart) {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.NEW);
        order.setOrderDateTime(Timestamp.valueOf(LocalDateTime.now()));
        cart.forEach((product, count) ->
                order.getOrderDetails().add(new OrderDetail(product.getId().toString(), count, product.getCost(), product.getName())));
        this.calculateAndSetTotalCost(order);
        return order;
    }
/*
    private void setDiscount(Order order) {
        String userUUID = order.getUser().getUUID();
        if (userService.isUserExist(userUUID)) {
            User userByUUID = userService.getUserByUUID(userUUID);
            order.setDiscount(userByUUID.getDiscount());
        }
    }*/

    private OrderUserinfo createUserInfo(CustomerOrderInfo customerOrderInfo) {
        TypedQuery<OrderUserinfo> orderUserinfoTypedQuery = entityManager.createQuery(SQL_SELECT_ORDERINFO_BY_NAME_AND_PHONE, OrderUserinfo.class);
        orderUserinfoTypedQuery.setParameter("name", customerOrderInfo.getName());
        orderUserinfoTypedQuery.setParameter("phone", customerOrderInfo.getPhone());
        OrderUserinfo orderUserinfo;
        try {
            orderUserinfo = orderUserinfoTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            logger.warn(e.getMessage());
            orderUserinfo = new OrderUserinfo(customerOrderInfo.getName(), customerOrderInfo.getPhone());
        } catch (NonUniqueResultException e) {
            logger.warn(e.getMessage());
            orderUserinfo = orderUserinfoTypedQuery.getResultStream().findFirst().get();
//            orderUserinfo = new OrderUserinfo(customerOrderInfo.getName(), customerOrderInfo.getPhone());
        }
        return orderUserinfo;
    }
}
