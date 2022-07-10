package com.mager.coffeeshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.mager.coffeeshop.repository")
public class AppConfig {
/*    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(environment.getProperty("spring.datasource.url"))
                .username(environment.getProperty("spring.datasource.username"))
                .password(environment.getProperty("spring.datasource.password"))
                .driverClassName(environment.getProperty("spring.datasource.driver-class-name"))
                .type(HikariDataSource.class)
                .build();
    }*/

}
