package com.javacode.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOverviewMain {
    private static List<Employee> employeeList = new ArrayList<>();
    private static List<Employee> secondList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee(1, "Alex", "Black", 50_000));
        employeeList.add(new Employee(2, "John", "Green", 75_000));
        employeeList.add(new Employee(6, "Sam", "Brown", 80_000));
        employeeList.add(new Employee(9, "Tony", "Grey", 90_000));
        employeeList.add(new Employee(10, "Mike", "Yellow", 60_000));
        employeeList.add(new Employee(11, "Victoria", "Pink", 75_000));
        employeeList.add(new Employee(16, "Sean", "Magenta", 80_000));
        employeeList.add(new Employee(19, "Kate", "Black", 88_000));
//        employeeList.add(new Employee(9, "Tony", "Grey", 90_000));
//        employeeList.add(new Employee(10, "Mike", "Yellow", 60_000));
//        employeeList.add(new Employee(11, "Victoria", "Pink", 75_000));

        secondList.add(new Employee(1, "Alex", "Black", 50_000));
        secondList.add(new Employee(2, "John", "Green", 75_000));
        secondList.add(new Employee(6, "Sam", "Brown", 80_000));
        secondList.add(new Employee(9, "Tony", "Grey", 90_000));
        secondList.add(new Employee(10, "Mike", "Yellow", 60_000));
        secondList.add(new Employee(11, "Victoria", "Pink", 75_000));
        secondList.add(new Employee(16, "Sean", "Magenta", 80_000));
        secondList.add(new Employee(19, "Kate", "Black", 88_000));
//        secondList.add(new Employee(9, "Tony", "Grey", 90_000));
//        secondList.add(new Employee(10, "Mike", "Yellow", 60_000));
//        secondList.add(new Employee(11, "Victoria", "Pink", 75_000));

        testStreamFormList();
//        testStreamFromFile();
    }

    private static void testStreamFormList() {
/*
        employeeList.stream()
                .filter(e -> e.getSalary() > 60_000)
                .filter(e -> e.getId() < 10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
*/

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

/*
        Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);
*/
/*
        Random r = new Random();
        Integer integer = Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .filter(i -> i % 5 == 0)
                .findFirst()
//                .orElse(0);
                .orElseGet(()->r.nextInt());
        System.out.println(integer);
*/
        Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .limit(1)
                .forEach(System.out::println);

/*
        Optional<Employee> first = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .findFirst();
        System.out.println(first);
*/
/*
        OptionalDouble average = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .average();
        System.out.println(average);
*/

        List<List<Employee>> departments = new ArrayList<>();
        departments.add(employeeList);
        departments.add(secondList);

//        departments.stream().flatMap(l -> l.stream().map(e -> e.getFirstName())).forEach(System.out::println);

/*
        Stream.of(ids).map(e -> String.format("%,3d", e)).forEach(System.out::print);
        System.out.println();
        Stream.of(ids)
//                .peek(e -> e = e * 2)
                .map(e -> String.format("%,3d", e * 2))
                .forEach(System.out::print);
        System.out.println();
*/
/*
        Consumer<Integer> c = e -> e = e * 2;
        Stream.of(ids).forEach(c);
        System.out.println(c);
*/
    }

    private static Employee findById(int id) {
        if (employeeMap == null) {
            employeeMap = employeeList.stream()
                    .distinct()
                    .collect(Collectors.toMap(Employee::getId, e -> e));
        }
        return employeeMap.get(id);
    }

    private static void testStreamFromFile() throws IOException {
        Files.lines((Paths.get("c:/000/words.txt")))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
