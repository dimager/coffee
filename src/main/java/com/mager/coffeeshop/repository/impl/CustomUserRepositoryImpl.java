package com.mager.coffeeshop.repository.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.CustomUserRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private final String FIND_USER_BY_USERNAME = "select u from User u where u.username = :username";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByUsername(String name) {
        System.out.println("name = " + name);
        TypedQuery<User> query = entityManager.createQuery(FIND_USER_BY_USERNAME, User.class);
        query.setParameter("username", name);
        return query.getSingleResult();
    }
}
