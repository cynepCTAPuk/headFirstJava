package com.javacode.lambdas;

import com.javacode.lambdas.model.Employee;
import com.javacode.lambdas.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaFunctionExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 50_000));
        employees.add(new Employee("John", "Green", 75_000));
        employees.add(new Employee("Sam", "Brown", 80_000));
        employees.add(new Employee("Tony", "Grey", 90_000));

        List<com.javacode.lambdas.model.Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Black", 25));
        people.add(new Person("John", "Green", 30));
        people.add(new Person("Sam", "Brown", 32));
        people.add(new Person("Tony", "Grey", 34));
//        Predicate
        System.out.println(findMatch(employees, e -> e.getSalary() > 80_000));
        System.out.println(findMatch(people, p -> p.getAge() > 30));

        
    }

    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction) {
        for (T e : elements) if (predicateFunction.test(e)) return e;
        return null;
    }
}
