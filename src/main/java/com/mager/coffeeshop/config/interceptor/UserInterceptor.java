package com.mager.coffeeshop.config.interceptor;

import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Objects;

@Component
public class UserInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public UserInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        Principal userPrincipal = request.getUserPrincipal();
        if (Objects.nonNull(userPrincipal) && Objects.nonNull(modelAndView)) {
            User userByPrincipal = userService.getUserByPrincipal(userPrincipal);
            modelAndView.getModelMap().addAttribute("userdata", userByPrincipal);
        }
    }
}
