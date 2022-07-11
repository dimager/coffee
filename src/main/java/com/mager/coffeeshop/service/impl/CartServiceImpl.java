package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.*;
import com.mager.coffeeshop.repository.CartRepository;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.OrderService;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public HashMap<Product, Integer> getCart(HttpSession httpSession, Principal principal, Authentication authentication) {
        Cart cart;
        if (authentication != null && authentication.isAuthenticated()) {
            cart = new Cart(userService.getUserData(principal));
        } else {
            cart = new Cart(httpSession.getId());
        }
        return getProductCartItems(cart);
    }

    @Override
    public void addToCart(Product product, Authentication authentication, Principal principal, HttpSession httpSession) {

        Optional<Cart> cartItem;
        Cart cart;
        User user = null;

        if (authentication != null && authentication.isAuthenticated()) {
            user = userService.getUserData(principal);
            cart = new Cart(user);
        } else {
            cart = new Cart(httpSession.getId());
        }

        cart.setProductId(product.getId().toString());
        Example<Cart> cartExample = Example.of(cart);
        cartItem = cartRepository.findOne(cartExample);

        if (cartItem.isPresent()) {
            Integer productCount = cartItem.get().getProductCount();
            cartItem.get().setProductCount(++productCount);
            cartRepository.save(cartItem.get());
        } else {
            Cart newCartItem = new Cart();
            if (authentication != null && authentication.isAuthenticated()) {
                newCartItem.setUser(user);
            } else {
                newCartItem.setSessionId(httpSession.getId());
            }
            newCartItem.setProductId(product.getId().toString());
            newCartItem.setProductCount(1);
            cartRepository.save(newCartItem);
        }
    }

    @Override
    public void deleteFromCart(Product product, Authentication authentication, Principal principal, HttpSession httpSession) {
        Optional<Cart> cartItem;
        Cart cart;
        if (authentication != null && authentication.isAuthenticated()) {
            cart = new Cart(userService.getUserData(principal));
        } else {
            cart = new Cart(httpSession.getId());
        }

        cart.setProductId(product.getId().toString());
        Example<Cart> cartExample = Example.of(cart);
        cartItem = cartRepository.findOne(cartExample);
        if (cartItem.isPresent()) {
            Integer productCount = cartItem.get().getProductCount();
            if (productCount > 1) {
                cartItem.get().setProductCount(--productCount);
                cartRepository.save(cartItem.get());
            } else {
                cartRepository.delete(cartItem.get());
            }
        }
    }

    private HashMap<Product, Integer> getProductCartItems(Cart cart) {
        List<Cart> all = cartRepository.findAll(Example.of(cart));
        HashMap<Product, Integer> cartItems = new HashMap<>();
        all.stream().forEach(cart1 -> cartItems.put(productService.getById(new ObjectId(cart1.getProductId())), cart1.getProductCount()));
        return cartItems;
    }

    @Override
    public void doOrder(HttpSession httpSession, Principal principal, Authentication authentication) {
        HashMap<Product, Integer> cart = getCart(httpSession, principal, authentication);
        Order order = new Order();
        cart.forEach((product, integer) -> order.getOrderDetails().add(new OrderDetail(product.getId().toString(), integer, product.getCost())));
        order.getOrderDetails().forEach(orderDetail -> orderDetail.setOrder(order));
        if (authentication != null && authentication.isAuthenticated()) {
            User user = userService.getUserData(principal);
            order.setUser(user);
            BigDecimal decimal = order.getOrderDetails().stream()
                    .map(orderDetail -> orderDetail.getProductCost().multiply(BigDecimal.valueOf(orderDetail.getProductCount())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            order.setCost(decimal);
        }
        System.out.println(order.getUser());
        System.out.println(order.getOrderDetails());
        orderService.doOrder(order);
    }
}
