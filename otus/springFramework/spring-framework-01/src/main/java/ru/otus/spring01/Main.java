package ru.otus.spring01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.service.PersonService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService service;
        service = context.getBean(PersonService.class);
//        service = (PersonService) context.getBean("personService");

        System.out.println(PersonService.class);
        System.out.println(service);
        System.out.println(service.getByName("Ivan"));
    }
}