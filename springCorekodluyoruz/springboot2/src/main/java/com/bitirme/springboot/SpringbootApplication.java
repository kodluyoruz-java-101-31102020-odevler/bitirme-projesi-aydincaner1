package com.bitirme.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.bitirme.springboot.repository" })
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
//run
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
