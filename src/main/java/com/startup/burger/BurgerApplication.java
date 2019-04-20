package com.startup.burger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BurgerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurgerApplication.class, args);
    }

}
