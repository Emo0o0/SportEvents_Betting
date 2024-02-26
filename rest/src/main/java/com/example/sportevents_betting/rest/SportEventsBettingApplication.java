package com.example.sportevents_betting.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sportevents_betting"})
@EntityScan(basePackages = {"com.example.sportevents_betting.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.example.sportevents_betting.persistence.repositories"})
public class SportEventsBettingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportEventsBettingApplication.class, args);
    }
}