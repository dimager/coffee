package com.mager.coffeeshop.validator;

import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PasswordValidator {
    int PASSWORD_MIN_LENGTH = 8;
    default void validatePassword(String password, Errors errors) {
        Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{" + PASSWORD_MIN_LENGTH + ",}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()) {
            errors.rejectValue("password", "field.password.notmatchpattern", "casdda");
        }
    }
}
