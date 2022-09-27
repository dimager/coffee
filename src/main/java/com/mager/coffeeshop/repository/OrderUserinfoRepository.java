package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.OrderUserinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderUserinfoRepository extends JpaRepository<OrderUserinfo, Long> {
}
