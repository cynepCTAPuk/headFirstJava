package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * https://www.baeldung.com/spring-boot-change-port
 * java -jar spring-5.jar --server.port=8083
 * java -jar -Dserver.port=8083 spring-5.jar
 */
@SpringBootApplication
@EnableScheduling
public class WebApplication {
    public static final long t = System.currentTimeMillis() / 60_000;
    private static final Logger log = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
//        SpringApplication application = new SpringApplication(WebApplication.class);
//        application.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//        application.run(args);
    }

    @Scheduled(fixedRate = 60_000)
    public void doOnSchedule() {
//        log.info("Log every 10 seconds: " + t);
        log.info(String.format("%,d mins", System.currentTimeMillis() / 60_000 - t));
    }
}
