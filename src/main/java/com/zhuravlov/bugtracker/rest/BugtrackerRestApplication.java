package com.zhuravlov.bugtracker.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableAutoConfiguration
public class BugtrackerRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugtrackerRestApplication.class, args);
    }

}
