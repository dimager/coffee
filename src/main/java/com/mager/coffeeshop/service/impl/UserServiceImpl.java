package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.UserRepository;
import com.mager.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        if (Objects.nonNull(authentication)) {
            System.out.println("authentication.getClass() = " + authentication.getClass());
        }
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            return userRepository.findByUsername(principal.getName());
        } else if (principal instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) principal;
            if ("google".equals(token.getAuthorizedClientRegistrationId())) {
                System.out.println("google");
            } else if ("github".equals(token.getAuthorizedClientRegistrationId())) {
                System.out.println("github");
            }
            token.getPrincipal().getAttributes().forEach((s, o) -> System.out.println(s + " - " + o));
            OAuth2User user = token.getPrincipal();
            System.out.println("token = " + token);
            return userRepository.findByUsername("guest");
        }
        return null;
    }


    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Override
    public User getUserFromSecurityContext() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            return userRepository.findByUsername(authentication.getName());
        } else if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
            OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
            System.out.println("client.getAccessToken().getTokenValue() = " + client.getAccessToken().getTokenValue());
            if ("google".equals(token.getAuthorizedClientRegistrationId())) {
                System.out.println("google");
            } else if ("github".equals(token.getAuthorizedClientRegistrationId())) {

                System.out.println("github");
                System.out.println("token = " + token);
            }
            return userRepository.findByUsername("guest");
        }
        return null;
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
//        if (authentication.isAuthenticated()) {
//            return this.getUserByPrincipal(userPrincipal).getUUID();
            return this.getUserFromSecurityContext().getUUID();
        } else {
            return request.getSession().getId();
        }
    }

    @Override
    public Boolean isUserExist(String UUID) {
        return userRepository.existsById(UUID);
    }
}

