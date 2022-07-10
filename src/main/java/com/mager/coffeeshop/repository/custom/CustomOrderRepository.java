package com.mager.coffeeshop.repository.custom;

import com.mager.coffeeshop.entity.Order;

import java.util.List;

public interface CustomOrderRepository {
    List<Order> findAllUserOrdersByUsername(String name);
}
