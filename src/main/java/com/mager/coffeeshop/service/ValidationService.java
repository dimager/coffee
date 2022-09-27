package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.User;
import org.springframework.validation.Errors;

public interface ValidationService {
    void validateSignupUserData(User user, Errors errors);
}
