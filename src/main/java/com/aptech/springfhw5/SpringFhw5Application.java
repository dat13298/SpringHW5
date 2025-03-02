package com.aptech.springfhw5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringFhw5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringFhw5Application.class, args);
    }

}
