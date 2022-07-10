package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {

    JdbcUserDetailsManager userDetailsManager;
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(JdbcUserDetailsManager userDetailsManager, UserRepository userRepository) {
        this.userDetailsManager = userDetailsManager;
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDetails userDetails) {
        userDetailsManager.createUser(userDetails);
    }

    @Override
    public void deleteUser(String username) {
        userDetailsManager.deleteUser(username);
    }

    @Override
    public User getUserData(Principal principal) {
        return userRepository.findByUsername(principal.getName());
//        Optional<User> one = userRepository.findOne(Example.of(new User(principal.getName())));
//        return userRepository.findById(one.get().getId()).get();
    }

    @Override
    public User getUserData2(Principal principal) {
        return userRepository.findOne(Example.of(new User(principal.getName()))).get();
    }


}

