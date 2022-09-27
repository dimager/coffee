package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    void createUser() {
        User user = new User();
        String uuid = user.getUUID();
        user.setUsername("testusername");
        user.setName("testname");
        user.setPassword("testpassword");
        user.setEnabled(true);
        userService.createUser(user);
        System.out.println("uuid = " + uuid);
        Assertions.assertEquals(userService.getUserByUsername("testusername").getUUID(),uuid);
    }

    @Test
    void getUserByUsername() {
        User guest = userService.getUserByUsername("guest");
        User admin = userService.getUserByUsername("admin");
        Assertions.assertAll(
                () -> assertTrue(guest.isGuest(), "guest is not present in DB"),
                () -> assertEquals("admin", admin.getUsername()));
    }

    @Test
    void getUserByUUID() {
        User guest = userService.getUserByUUID("guest");
        assertTrue(guest.isGuest());
    }
}