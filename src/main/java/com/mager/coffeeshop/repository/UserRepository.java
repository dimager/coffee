package com.mager.coffeeshop.repository;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.custom.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {


}
