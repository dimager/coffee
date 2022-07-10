package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Order;
import org.springframework.data.domain.Page;

import java.security.Principal;

public interface OrderService {
    Page<Order> getUserOrders(Principal principal, int page);
}
