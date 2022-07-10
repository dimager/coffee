package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long> {
}
