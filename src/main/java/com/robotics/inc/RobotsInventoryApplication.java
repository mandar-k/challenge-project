package com.robotics.inc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class RobotsInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotsInventoryApplication.class, args);
    }

    @PostConstruct
    public void init() {
        log.debug("Robots Inventory Application Started...!!!");
    }

}
