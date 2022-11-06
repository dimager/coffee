package com.mager.coffeeshop.config.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LogManager.getLogger("LogInterceptor");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getUserPrincipal() != null) {
            logger.warn("user is - " + request.getUserPrincipal().getName());
        } else {
            logger.warn("guest --");
        }
        logger.debug("request.getRequestURI() = " + request.getRequestURI());
        return true;
    }
}
