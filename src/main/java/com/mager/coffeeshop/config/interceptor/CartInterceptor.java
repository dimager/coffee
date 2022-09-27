package com.mager.coffeeshop.config.interceptor;

import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CartInterceptor implements HandlerInterceptor {
    private final CartService cartService;

    public CartInterceptor(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (Objects.nonNull(modelAndView)) {
            Map<Product, Integer> cart = cartService.getUserProductCart();
            ModelMap model = modelAndView.getModelMap();
            AtomicInteger totalPrice = new AtomicInteger();
            cart.forEach((product, integer) -> totalPrice.addAndGet(product.getCost().intValue() * integer));
            Integer cartItemsCount = cart.values().stream().reduce(Integer::sum).orElse(0);
          /*  model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("cartCount", cartItemsCount);
            model.addAttribute("cart", cart);*/
            modelAndView.addObject("cart",cart);
            modelAndView.addObject("cartCount",cartItemsCount);
            modelAndView.getModel().put("totalPrice",totalPrice);

        }
    }
}
