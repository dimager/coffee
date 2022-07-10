package com.mager.coffeeshop.repository.custom.impl;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.repository.custom.CustomOrderRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomOrderRepositoryImpl implements CustomOrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final String FIND_USER_ORDERS_BY_USERNAME = "select o from Order o where o.user = :user";
    private final String FIND_USER_ORDERS_BY_USERNAME2 = "select o from Order o where o.user.username = :username";
    @Override
    public List<Order> findAllUserOrdersByUsername(String name) {
        TypedQuery<Order>  query = entityManager.createQuery(FIND_USER_ORDERS_BY_USERNAME2,Order.class);
        query.setParameter("username", name);
        return query.getResultList();
    }
}
