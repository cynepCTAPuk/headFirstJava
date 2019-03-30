package com.javacode.lambdas;

import com.javacode.lambdas.model.Employee;
import com.javacode.lambdas.model.Person;

import java.util.ArrayList;
import java.util.List;

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
    }
}
