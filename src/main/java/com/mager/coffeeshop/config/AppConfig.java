package com.mager.coffeeshop.config;

import ch.itds.taglib.phonenumber.PhoneNumberDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

@Configuration
//@EnableMongoRepositories(basePackages = "com.mager.coffeeshop.repository")
//@EnableJpaRepositories(basePackages = "com.mager.coffeeshop.repository")
@EnableMongoHttpSession
public class AppConfig {
    @Bean
    public PhoneNumberDialect phoneNumberDialect() {
        return new PhoneNumberDialect();
    }


}
