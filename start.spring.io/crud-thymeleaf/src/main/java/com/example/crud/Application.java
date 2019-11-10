/**
 * https://www.baeldung.com/spring-boot-crud-thymeleaf
 * https://github.com/eugenp/tutorials/tree/master/spring-boot-crud/src/main/java/com/baeldung/crud
 */
package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.example.crud"})
@EnableJpaRepositories(basePackages="com.example.crud.repositories")
@EnableTransactionManagement
@EntityScan(basePackages="com.example.crud.entities")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}