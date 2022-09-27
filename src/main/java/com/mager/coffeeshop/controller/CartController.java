package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.dto.CustomerOrderInfo;
import com.mager.coffeeshop.entity.Location;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.LocationService;
import com.mager.coffeeshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {
    private final CartService cartService;
    private final LocationService locationService;

    public CartController(CartService cartService, LocationService locationService) {
        this.cartService = cartService;
        this.locationService = locationService;
    }

    @PostMapping(value = {"/addtocart", "/additem"})
    public RedirectView addToCart(@ModelAttribute(value = "productToCart") Product product, HttpServletRequest request) {
        cartService.addToCart(product);
        RedirectView redirectView;
        if (request.getRequestURI().equals("/addtocart")) {
            redirectView = new RedirectView("/cart");
        } else {
            redirectView = new RedirectView("/");
        }
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }

    @PostMapping("/deletefromcart")
    public RedirectView deleteFromCart(@ModelAttribute(value = "deleteProductFromCart") Product product) {
        cartService.deleteFromCart(product);
        RedirectView redirectView = new RedirectView("/cart");
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }

    @GetMapping("/cart")
    public String viewCartPage(@ModelAttribute(name = "orderInfo") CustomerOrderInfo customerOrderInfo,
                               @ModelAttribute(name = "location") Location location,
                               Model model) {
        model.addAttribute("points", locationService.getJSPoint());
        return "cart.html";
    }
}
