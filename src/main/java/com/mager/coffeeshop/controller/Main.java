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
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger totalPrice = new AtomicInteger();
        cart.forEach((product, integer) -> totalPrice.addAndGet(product.getCost().intValue() * integer));
        model.addAttribute("totalPrice", totalPrice);
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

    @RequestMapping("/doorder")
    public String doOrder(HttpSession httpSession, Principal principal, Authentication authentication) {
        cartService.doOrder(httpSession, principal, authentication);
        return "index.html";
    }


    @PostMapping("/addtocart")
    public RedirectView addToCart(@ModelAttribute(value = "addProductToCart") Product product,
                                  Authentication authentication,
                                  HttpSession httpSession,
                                  Principal principal) {
        cartService.addToCart(product, authentication, principal, httpSession);
        return new RedirectView("/");
    }

    @PostMapping("/additem")
    public RedirectView addItem(@ModelAttribute(value = "addProductToCart") Product product,
                                Authentication authentication,
                                HttpSession httpSession,
                                Principal principal) {
        cartService.addToCart(product, authentication, principal, httpSession);
        return new RedirectView("/cart");
    }

    @PostMapping("/deletefromcart")
    public RedirectView deleteFromCart(@ModelAttribute(value = "deleteProductFromCart") Product product,
                                       Authentication authentication,
                                       HttpSession httpSession,
                                       Principal principal) {
        cartService.deleteFromCart(product, authentication, principal, httpSession);
        return new RedirectView("/cart");
    }


    @RequestMapping("/admin")
    public String viewAdminPage() {
        return "admin.html";
    }

    @RequestMapping("/cart")
    public String viewCartPage() {
        return "cart.html";
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
