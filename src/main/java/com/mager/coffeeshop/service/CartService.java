package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Product;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;

public interface CartService {
    HashMap<Product, Integer> getCart(HttpSession httpSession, Principal principal, Authentication authentication);
    void addToCart(Product product, Authentication authentication, Principal principal, HttpSession httpSession);

    void deleteFromCart(Product product, Authentication authentication, Principal principal, HttpSession httpSession);


    void doOrder(HttpSession httpSession, Principal principal, Authentication authentication);
}
