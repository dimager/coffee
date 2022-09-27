package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.OrderDetail;
import com.mager.coffeeshop.dto.CustomerOrderInfo;
import com.mager.coffeeshop.entity.Product;
import org.springframework.data.domain.Page;

import java.security.Principal;
import java.util.Map;

public interface OrderService {

    Page<Order> getUserOrders(Principal principal, int page);

    Page<Order> getOrders(Long locationId, Integer page, String orderStatus);

    Map<OrderDetail, Product> getOrderDetails(Order order);

    Order getOrder(Order order);

    Order getOrderById(Long orderId);

    void changeDiscount(Order updateOrder);

    void changeStatus(Order updateOrder);

    void doOrder(CustomerOrderInfo customerOrderInfo);

    boolean isOrderExist(Long orderId);
}
