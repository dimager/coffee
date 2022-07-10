package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public interface UserService {
    void createUser(UserDetails userDetails);

    void deleteUser(String username);

    User getUserData(Principal principal);

    User getUserData2(Principal principal);
}
