package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
