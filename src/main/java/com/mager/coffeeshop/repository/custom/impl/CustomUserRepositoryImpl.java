package com.mager.coffeeshop.repository.custom.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.custom.CustomUserRepository;
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
        TypedQuery<User> query = entityManager.createQuery(FIND_USER_BY_USERNAME, User.class);
        query.setParameter("username", name);
        return query.getSingleResult();
    }
}
