package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.OrdersRepository;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Override
    public void doOrder(Order order) {
        ordersRepository.save(order);
    }

    @Override
    public Page<Order> getUserOrders(Principal principal, int page) {
        Order order = new Order();
        User user = userRepository.findByUsername(principal.getName());
        order.setUser(user);
        order.setOrderDateTime(null);
        order.setCost(null);
        order.setOrderStatus(null);
        Example<Order> example = Example.of(order);
        return ordersRepository.findAll(example, Pageable.ofSize(10).withPage(page));
    }

}
