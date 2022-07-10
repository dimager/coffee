package com.mager.coffeeshop;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.repository.OrdersRepository;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.service.impl.ProductServiceImpl;
import com.mager.coffeeshop.service.impl.UserServiceImpl;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.util.Base64;

@SpringBootApplication
public class CoffeeShopApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }

    @Autowired
    UserServiceImpl userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
//        Order order = new Order();
//        order.setUser(userRepository.getReferenceById(2L));
//        ordersRepository.save(order);
//        System.out.println("mongotest");
//        Product product = new Product();
//        product.setName("black");
//        product.setCost(new BigDecimal("12.00"));
//        product.setId(ObjectId.get());
//        product.setImageBase64("");
//        productService.addProduct(product);
//        productService.getAll().forEach(System.out::println);
//        System.out.println("productService.getById(1L) = " + productService.getById(1L));
//        UserDetails build = User.builder().username("user").password(passwordEncoder.encode("pass")).authorities(Roles.ROLE_USER.name()).build();
//        userService.createUser(build);
    }
}
