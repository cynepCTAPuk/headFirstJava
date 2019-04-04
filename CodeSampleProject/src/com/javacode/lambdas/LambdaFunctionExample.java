package com.javacode.lambdas;

import com.javacode.lambdas.model.Circle;
import com.javacode.lambdas.model.Employee;
import com.javacode.lambdas.model.Person;
import com.javacode.lambdas.model.Rectangle;
import com.javacode.lambdas.model.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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
/*
        System.out.println(findMatch(employees, e -> e.getSalary() > 80_000));
        System.out.println(findMatch(people, p -> p.getAge() > 30));
*/

//        Function
/*
        System.out.printf("Total salary: %,d%n", calcSum(employees, Employee::getSalary));
        System.out.printf("Total age: %,d%n", calcSum(people, Person::getAge));
*/

//        BiFunction
/*
        BinaryOperator<Integer> combiner = (n1, n2) -> Math.max(n1, n2);
        Integer zeroElement = 0;
        System.out.printf("Combine result: %,d%n",
                combine(employees, zeroElement, Employee::getSalary, combiner));
*/

//        Consumer
/*
        employees.forEach(System.out::println);
        employees.forEach(e -> e.setSalary((e.getSalary() * 11 / 10)));
        employees.forEach(System.out::println);
*/

//        Supplier
        Supplier[] shapes = {Circle::new, Rectangle::new, Square::new};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(3);
            Supplier supplier = shapes[index];
            supplier.get();
        }
    }

    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction) {
        for (T e : elements) if (predicateFunction.test(e)) return e;
        return null;
    }

    private static <T> int calcSum(List<T> elements, Function<T, Integer> function) {
        int sum = 0;
        for (T e : elements) sum = sum + function.apply(e);
        return sum;
    }

    private static <T, R> R combine(
            List<T> elements, R zeroElement, Function<T, R> function, BinaryOperator<R> combiner) {
        for (T e : elements) zeroElement = combiner.apply(zeroElement, function.apply(e));
        return zeroElement;
    }
}
