package com.mager.coffeeshop.config;

import com.mager.coffeeshop.config.interceptor.CartInterceptor;
import com.mager.coffeeshop.config.interceptor.LocationsInterceptor;
import com.mager.coffeeshop.config.interceptor.LogInterceptor;
import com.mager.coffeeshop.config.interceptor.ProductsInterceptor;
import com.mager.coffeeshop.config.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private ProductsInterceptor productsInterceptor;
    @Autowired
    private LocationsInterceptor locationsInterceptor;
    @Autowired
    private LogInterceptor logInterceptor;
    @Autowired
    private CartInterceptor cartInterceptor;
    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/test").setViewName("test.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(locationsInterceptor).excludePathPatterns("/static/**", "/img/**", "/css/**");
        registry.addInterceptor(userInterceptor).excludePathPatterns("/static/**", "/img/**", "/css/**");
        registry.addInterceptor(logInterceptor).excludePathPatterns("/static/**", "/img/**", "/css/**", "/error");
        registry.addInterceptor(localeChangeInterceptor()).excludePathPatterns("/static/**", "/img/**", "/css/**");
        registry.addInterceptor(productsInterceptor).addPathPatterns("/cart", "/");
        registry.addInterceptor(cartInterceptor).excludePathPatterns("/static/**", "/img/**", "/css/**", "/error");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/static/**", "/img/**", "/css/**")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }

    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);

    }
}
