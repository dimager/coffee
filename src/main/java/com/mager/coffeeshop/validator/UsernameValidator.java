package com.mager.coffeeshop.validator;

import org.springframework.validation.Errors;

public interface UsernameValidator {
    void validateUser(String username, Errors errors);
}



