package com.mager.coffeeshop.validator.impl;

import com.mager.coffeeshop.validator.UsernameValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UsernameValidatorImpl implements UsernameValidator {
    @Value("${username.regex:^[a-zA-Z0-9]}")
    private String REGEX;
    @Value("${username.maxlength:16}")
    private int USERNAME_MAX_LENGTH;
    @Value("${username.minlength:3}")
    private int USERNAME_MIN_LENGTH;

    @Override
    public void validateUser(String username, Errors errors) {
        Pattern usernamePattern = Pattern.compile(REGEX+"{" + USERNAME_MIN_LENGTH + "," + USERNAME_MAX_LENGTH + "}$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if (!usernameMatcher.matches()) {
            errors.rejectValue("username", "field.username.notmatchpattern");
        }
    }
}
