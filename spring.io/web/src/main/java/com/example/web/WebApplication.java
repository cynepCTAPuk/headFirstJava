package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * https://www.baeldung.com/spring-boot-change-port
 * java -jar spring-5.jar --server.port=8083
 * java -jar -Dserver.port=8083 spring-5.jar
 * 
 */
@SpringBootApplication
public class WebApplication {
    private static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(WebApplication.class, args);
        SpringApplication application = new SpringApplication(WebApplication.class);
//        application.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        application.run(args);
    }
}
