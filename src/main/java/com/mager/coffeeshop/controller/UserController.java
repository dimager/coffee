package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    private final OrderService orderService;

    public UserController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/userinfo")
    public String viewUserInfoPage(Principal principal,
                                   @RequestParam(name = "page") Optional<Integer> page,
                                   Model model) {
        int currentPage = page.orElse(0);
        Page<Order> userOrders = orderService.getUserOrders(principal, currentPage);
        model.addAttribute("userorders", userOrders);
        model.addAttribute("currentPage", currentPage);
        return "userinfo.html";
    }

}
