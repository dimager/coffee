package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Test
    void getUserByUUID() {

        Page<Order> aNew = orderService.getOrders(1L, 1, "NEW");

        aNew.getContent().forEach(System.out::println);

    }
}