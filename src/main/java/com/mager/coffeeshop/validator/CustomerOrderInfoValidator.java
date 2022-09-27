package com.mager.coffeeshop.validator;

import com.mager.coffeeshop.dto.CustomerOrderInfo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomerOrderInfoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerOrderInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
