package com.example.Customer.Management.System;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.Customer.Management.System") // Replace with your package name
public class AppConfig {

    @Bean
    public CustomerService customerService(@Qualifier("notificationServiceImpl") NotificationService notificationService) {
        return new CustomerServiceImpl();
    }
    

    @Bean
    public NotificationService notificationService() {
        return new NotificationServiceImpl();
    }
}

