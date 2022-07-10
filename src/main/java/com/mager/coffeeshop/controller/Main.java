package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.entity.Order;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.impl.OrderServiceImpl;
import com.mager.coffeeshop.service.impl.ProductServiceImpl;
import com.mager.coffeeshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class Main {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JdbcUserDetailsManager userDetailsManager;
    @Autowired
    CartService cartService;

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    OrderServiceImpl orderService;

    @ModelAttribute("products")
    public List<Product> allProd() {
        List<Product> all = productService.getAll();
        return all;
    }

    @ModelAttribute("cart")
    public HashMap<Product, Integer> getCart(HttpSession httpSession, Model model, Authentication authentication, Principal principal) {
        HashMap<Product, Integer> cart = cartService.getCart(httpSession, principal, authentication);
//        model.addAttribute("cartCount", cart.size());
        model.addAttribute("cartCount", cart.values().stream().reduce(Integer::sum).orElse(0));
        return cart;
    }

    @ModelAttribute("userdata")
    public User getUserData(Principal principal) {
        if (Objects.nonNull(principal)) {
            User user = userService.getUserData(principal);
            return user;
        }
        return null;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "index.html";
    }

    @PostMapping("/logout")
    public String logout() {
        return "index.html";
    }

    @RequestMapping("/login")
    public String login() {
        return "index.html";
    }

    @PostMapping("/addtocart")
    public RedirectView addToCart(@ModelAttribute(value = "aaa") Product product, Authentication authentication, HttpSession httpSession, Principal principal) {
        if (authentication != null && authentication.isAuthenticated()) {
            cartService.addToCart(product, principal);
        } else {
            cartService.addToCart(product, httpSession.getId());
        }
        return new RedirectView("/");
    }


    @RequestMapping("/admin")
    public String viewAdminPage() {
        return "admin.html";
    }

    @RequestMapping("/login-error")
    public String viewErrorPage(Model model) {
        model.addAttribute("loginError", true);
        return "index.html";
    }


    @GetMapping("/userinfo")
    public String viewUserInfoPage(Principal principal, HttpSession httpSession
            , @RequestParam(name = "page") Optional<Integer> page,
                                   Model model) {
        System.out.println("httpSession.getId() = " + httpSession.getId());
        int currentPage = page.orElse(0);
        Page<Order> userOrders = orderService.getUserOrders(principal, currentPage);
        model.addAttribute("userorders", userOrders);
        model.addAttribute("currentPage", currentPage);
        return "userinfo.html";
    }

}
