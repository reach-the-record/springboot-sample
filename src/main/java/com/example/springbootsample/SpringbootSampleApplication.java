package com.example.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
public class SpringbootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSampleApplication.class, args);
    }
    // JsonParser에 필요한 build.gradle, DateTimeSerializer& Deserializer
}
