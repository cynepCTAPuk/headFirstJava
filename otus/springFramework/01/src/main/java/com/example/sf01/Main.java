package com.example.sf01;

import com.example.sf01.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/spring-context.xml");
        PersonService s;
//        s = context.getBean(PersonService.class);
        s = (PersonService) context.getBean("personService");

        System.out.println(PersonService.class);
        System.out.println(s);
        System.out.println(s.getByName("Ivan"));
    }
}