package com.mager.coffeeshop.security.config;

import com.mager.coffeeshop.security.Roles;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @PersistenceContext
    EntityManager entityManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/static/**", "/","/signup","errors/**","/change-locale").permitAll()
                .antMatchers("/userinfo").hasRole(Roles.USER.name())
                .antMatchers("/admin", "/orders", "/order-details", "/change-discount", "/change-status","/products","/edit-product/**","/delete-product/**","/add-product").hasRole(Roles.ADMIN.name())
                .and()
                .oauth2Login()
                .and()
                .formLogin()
                .loginPage("/")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/error-page")
                .and().csrf();
        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager() {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        return new JdbcUserDetailsManager(info.getDataSource());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
