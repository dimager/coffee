package com.mager.coffeeshop.validator;

import com.mager.coffeeshop.entity.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator, PasswordValidator {

    private final JdbcUserDetailsManager userDetailsManager;
    private final UsernameValidator usernameValidator;

    public UserValidator(JdbcUserDetailsManager userDetailsManager, UsernameValidator usernameValidator) {
        this.userDetailsManager = userDetailsManager;
        this.usernameValidator = usernameValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userDetailsManager.userExists(user.getUsername())) {
            errors.rejectValue("username", "field.username.exist", "asdfwerq");
        }
//        validateUserIsExist(user.getUsername());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "field.username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.phone.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.password.required");

        usernameValidator.validateUser(user.getUsername(), errors);
        validatePassword(user.getPassword(), errors);

    }

}
