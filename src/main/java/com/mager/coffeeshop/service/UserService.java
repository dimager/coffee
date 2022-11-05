package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.User;

import java.security.Principal;

public interface UserService {
    void createUser(User user);

    User getUserByPrincipal(Principal principal);

    User getUserFromSecurityContext();

    User getUserByUsername(String username);

    User getUserByUUID(String UUID);

    String getCustomerUUID();

    Boolean isUserExist(String UUID);

}
