package com.mager.coffeeshop.config.interceptor;

import com.mager.coffeeshop.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProductsInterceptor implements HandlerInterceptor {
    private final ProductService productService;

    public ProductsInterceptor(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        modelAndView.getModelMap().addAttribute("products", productService.getAll());
    }
}
