package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Cart;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.CartRepository;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public void addToCart(Product product, Principal principal) {
        User userData = userService.getUserData(principal);
        Cart cart = new Cart();
        cart.setUser(userData);
        cart.setProductId(product.getId().toString());
        Example<Cart> cartExample = Example.of(cart);
        Optional<Cart> cartItem = cartRepository.findOne(cartExample);
        if (cartItem.isPresent()) {
            Integer productCount = cartItem.get().getProductCount();
            cartItem.get().setProductCount(++productCount);
            cartRepository.save(cartItem.get());
        } else {
            Cart cart1 = new Cart();
            cart1.setUser(userData);
            cart1.setProductCount(1);
            cart1.setProductId(product.getId().toString());
            cartRepository.save(cart1);
        }
    }

    @Override
    public void addToCart(Product product, String sessionId) {
        Cart cart = new Cart(sessionId);
        cart.setProductId(product.getId().toString());
        Example<Cart> cartExample = Example.of(cart);
        Optional<Cart> cartItem = cartRepository.findOne(cartExample);
        if (cartItem.isPresent()) {
            Integer productCount = cartItem.get().getProductCount();
            cartItem.get().setProductCount(++productCount);
            cartRepository.save(cartItem.get());
        } else {
            Cart cart1 = new Cart();
            cart1.setSessionId(sessionId);
            cart1.setProductCount(1);
            cart1.setProductId(product.getId().toString());
            cartRepository.save(cart1);
        }
    }

    @Override
    public HashMap<Product, Integer> getCart(HttpSession httpSession, Principal principal, Authentication authentication) {
        Cart cart;
        if (authentication!=null && authentication.isAuthenticated()){
            cart = new Cart(userService.getUserData(principal));
        }
        else {
            cart = new Cart(httpSession.getId());
        }
        return getProductCartItems(cart);
    }

    private HashMap<Product, Integer> getProductCartItems(Cart cart) {
        List<Cart> all = cartRepository.findAll(Example.of(cart));
        HashMap<Product, Integer> cartItems = new HashMap<>();
        all.stream().forEach(cart1 -> cartItems.put(productService.getById(new ObjectId(cart1.getProductId())),cart1.getProductCount()));
        return cartItems;
    }

//    @Override
//    public void doOrder(){
//
//    }
}
