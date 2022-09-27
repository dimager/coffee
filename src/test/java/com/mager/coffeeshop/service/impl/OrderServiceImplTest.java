package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.OrderStatus;
import com.mager.coffeeshop.service.OrderService;
import com.mager.coffeeshop.service.UserService;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Test
    void getUserOrders() {
        Principal principal = new UserPrincipal("user");
        orderService.getUserOrders(principal,0).getContent().forEach(System.out::println);
    }

    @Test
    void getOrders() {
    }

    @Test
    void getOrderDetails() {
    }

    @Test
    void getOrder() {
    }

    @Test
    void changeDiscount() {
        Order order = new Order();
        order.setId(300L);
        Order orderFromDB = orderService.getOrder(order);
        orderFromDB.setDiscount(35);
        orderService.changeDiscount(orderFromDB);
        orderFromDB = orderService.getOrder(order);
        assertEquals(35, orderFromDB.getDiscount());
    }

    @Test
    void changeStatus() {
/*        Order order = new Order();
        order.setId(300L);
        Order orderFromDB = orderService.getOrder(order);
        assertEquals(orderFromDB.getOrderStatus(), OrderStatus.NEW);
        orderFromDB.setOrderStatus(OrderStatus.CONFIRMED);
        orderService.changeStatus(orderFromDB);
        orderFromDB = orderService.getOrder(order);
        assertEquals(orderFromDB.getOrderStatus(), OrderStatus.CONFIRMED);*/
    }

    @Test
    void doOrder() {

    }

    @Test
    void saveOrder() {
    }
}