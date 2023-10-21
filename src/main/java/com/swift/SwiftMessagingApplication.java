package com.swift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ConfigurationProperties
@ComponentScan(basePackages = "com.swift")
public class SwiftMessagingApplication {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SpringApplication.run(SwiftMessagingApplication.class, args);
    }
}