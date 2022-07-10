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
                .antMatchers("/static/**").permitAll()
                .antMatchers("/admin").hasRole(Roles.ADMIN.name())
                .antMatchers("/userinfo").hasAnyRole(Roles.ADMIN.name(), Roles.USER.name())
                .antMatchers("/order").hasAnyRole(Roles.ADMIN.name(), Roles.USER.name())
                .and()
                .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutSuccessUrl("/");
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
