package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.validator.UserValidator;
import com.mager.coffeeshop.service.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class ValidationServiceImpl implements ValidationService {
    private final UserValidator userValidator;

    public ValidationServiceImpl(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    public void validateSignupUserData(User user, Errors errors) {
        userValidator.validate(user, errors);
    }
}
