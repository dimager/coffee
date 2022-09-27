package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
