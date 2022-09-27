package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.service.UserService;
import com.mager.coffeeshop.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    private final UserService userService;
    private final ValidationService validationService;

    public AuthenticationController(UserService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }

    @GetMapping("/signup")
    public String getSignupPage(@ModelAttribute("user") User user) {
        return "signup.html";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user, BindingResult bindingResult) {
        validationService.validateSignupUserData(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.createUser(user);
        return "index.html";
    }


    @RequestMapping("/login-error")
    public String viewErrorPage(Model model) {
        model.addAttribute("loginError", true);
        return "index.html";
    }

}
