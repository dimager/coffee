package com.mager.coffeeshop.config;

import ch.itds.taglib.phonenumber.PhoneNumberDialect;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.MongoIndexedSessionRepository;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

import java.time.Duration;

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
