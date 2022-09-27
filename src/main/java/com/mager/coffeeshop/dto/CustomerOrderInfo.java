package com.mager.coffeeshop.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomerOrderInfo {

    private long locationId;
    private String name;
    private String phone;

}
