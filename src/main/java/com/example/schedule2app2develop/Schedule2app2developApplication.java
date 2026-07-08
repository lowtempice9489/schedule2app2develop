package com.example.schedule2app2develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Schedule2app2developApplication {

    public static void main(String[] args) {
        SpringApplication.run(Schedule2app2developApplication.class, args);
    }

}
