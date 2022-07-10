package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Product;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;

public interface CartService {
    void addToCart(Product product, Principal principal);
    void addToCart(Product product, String sessionId);
    HashMap<Product, Integer> getCart(HttpSession httpSession, Principal principal, Authentication authentication);
}
