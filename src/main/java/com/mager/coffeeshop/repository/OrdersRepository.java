package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long>, CustomOrderRepository {
}
