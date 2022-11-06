package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
public class MainController {

    private final SessionLocaleResolver localeResolver;
    private final ProductService productService;

    public MainController(SessionLocaleResolver localeResolver, ProductService productService) {
        this.localeResolver = localeResolver;
        this.productService = productService;
    }

    @ModelAttribute("products")
    public List<Product> allProd() {
        List<Product> all = productService.getAll();
        return all;
    }

    @ModelAttribute("username_pattern")
    public String usernamePattern() {
        return "^[a-zA-Z0-9]{3,16}$";
    }

/*
    @ModelAttribute("userdata")
    public User getUserData(Principal principal) {
        if (Objects.nonNull(principal)) {
            return userService.getUserByPrincipal(principal);
        }
        return null;
    }
*/

    @GetMapping("/")
    public String viewHomePage(@ModelAttribute("productToCart") Product product) {
        return "index.html";
    }


    @PostMapping("/change-locale")
    public RedirectView changeLocale(HttpServletRequest request, HttpServletResponse response, String locale) {
        System.out.println("locale = " + locale);
        localeResolver.setLocale(request, response, new Locale(locale));
        return new RedirectView("/");
    }
}
