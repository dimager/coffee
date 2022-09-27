package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final HttpServletRequest request;
    private final PasswordEncoder passwordEncoder;
    private final JdbcUserDetailsManager userDetailsManager;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(JdbcUserDetailsManager userDetailsManager, UserRepository userRepository, HttpServletRequest request, PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.userRepository = userRepository;
        this.request = request;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsManager.createUser(user);
        User byUsername = userRepository.findByUsername(user.getUsername());
        byUsername.setEmail(user.getEmail());
        byUsername.setPhone(user.getPhone());
        byUsername.setName(user.getName());
        userRepository.save(byUsername);
    }

    @Override
    public User getUserByPrincipal(Principal principal) {
        return userRepository.findByUsername(principal.getName());
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByUUID(String UUID) {
        Optional<User> byId = userRepository.findById(UUID);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return userRepository.findByUsername("guest");
        }
    }

    @Override
    public String getCustomerUUID() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Principal userPrincipal = request.getUserPrincipal();
        if (authentication.isAuthenticated() && Objects.nonNull(userPrincipal)) {
            return this.getUserByPrincipal(userPrincipal).getUUID();
        } else {
            return request.getSession().getId();
        }
    }

    @Override
    public Boolean isUserExist(String UUID) {
        return userRepository.existsById(UUID);
    }
}

