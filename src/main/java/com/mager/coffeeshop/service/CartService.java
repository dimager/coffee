package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.CartItem;
import com.mager.coffeeshop.entity.Product;

import java.util.List;
import java.util.Map;

public interface CartService {

    void cleanUserCart();

    Map<Product, Integer> getUserProductCart();

    List<CartItem> getUserCart(String UUID);

    void addToCart(Product product);

    void deleteFromCart(Product product);
}
