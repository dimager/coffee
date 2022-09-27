package com.mager.coffeeshop;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.OrdersRepository;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.security.Roles;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import com.mager.coffeeshop.service.impl.ProductServiceImpl;
import com.mager.coffeeshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
@EnableScheduling
public class CoffeeShopApplication implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    ProductService productService;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JdbcUserDetailsManager userDetailsManager;

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
