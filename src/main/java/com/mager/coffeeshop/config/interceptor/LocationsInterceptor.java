package com.mager.coffeeshop.config.interceptor;

import com.mager.coffeeshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LocationsInterceptor implements HandlerInterceptor {

    private final LocationService locationService;

    public LocationsInterceptor(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.getModelMap().addAttribute("locations", locationService.getAllLocations());
        }
    }
}
