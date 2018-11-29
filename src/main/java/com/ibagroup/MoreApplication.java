package com.ibagroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoreApplication.class, args);
    }
	
}
