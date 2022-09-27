package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.User;

public interface CustomUserRepository {
    User findByUsername(String name);
}
