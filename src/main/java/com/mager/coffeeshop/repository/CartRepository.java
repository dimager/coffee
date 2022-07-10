package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
