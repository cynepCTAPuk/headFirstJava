package ru.javabegin.training.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.impls.robot.ModelT1000;

public class Start {
    public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	System.out.println("\n--t1000");
	ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
	t1000.action();
	/*
	 * System.out.println("\n--t1000Empty"); ModelT1000 t1000Empty = (ModelT1000)
	 * context.getBean("t1000Empty"); t1000Empty.action();
	 * System.out.println("\n--t1000p"); ModelT1000 t1000p = (ModelT1000)
	 * context.getBean("t1000p"); t1000p.action();
	 */
	((ConfigurableApplicationContext) context).close();
    }
}
