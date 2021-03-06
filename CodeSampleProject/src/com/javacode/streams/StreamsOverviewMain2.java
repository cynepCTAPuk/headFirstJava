package com.javacode.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsOverviewMain2 {
    private static List<Employee2> employeeList = new ArrayList<>();
    private static List<Employee2> secondList = new ArrayList<>();
    private static Map<Integer, Employee2> Employee2Map = null;

    public static void main(String[] args) throws IOException {
        employeeList.add(new Employee2(1, "Alex", "Black", 50_000, "IT"));
        employeeList.add(new Employee2(2, "John", "Green", 75_000, "IT"));
        employeeList.add(new Employee2(6, "Sam", "Brown", 80_000, "IT"));
        employeeList.add(new Employee2(9, "Tony", "Grey", 90_000, "IT"));
        employeeList.add(new Employee2(10, "Mike", "Yellow", 60_000, "IT"));
        employeeList.add(new Employee2(11, "Victoria", "Pink", 75_000, "IT"));
        employeeList.add(new Employee2(16, "Sean", "Magenta", 80_000, "Finance"));
        employeeList.add(new Employee2(19, "Kate", "Black", 88_000, "Finance"));
        employeeList.add(new Employee2(9, "Tony", "Grey", 90_000, "Finance"));
        employeeList.add(new Employee2(10, "Mike", "Yellow", 60_000, "IT"));
        employeeList.add(new Employee2(11, "Victoria", "Pink", 75_000, "Finance"));

//        testStreamFormList();
//        testStreamFromFile();
//        testSortAndReduce();
//        partitionByIncome();
//        groupByCriterion(Employee2::getDepartment);
//        testStreamGenerator(10);
//        testStreamIterator(10);
//        testParallelStream();
        Supplier<Integer> supplier = new Supplier<Integer>() {
            private int previous = 0;
            private int current = 1;
            @Override
            public Integer get() {
                int next = previous + current;
                previous = current;
                current = next;
                return current;
            }
        };
//        testStreamGeneratorSupplier(10, supplier);
    }

    private static void testParallelStream() throws IOException {
        employeeList
                .stream()
//                .parallelStream()
                .map(Employee2::getLastName)
                .sorted()
//                .collect(Collectors.toList())
                .forEach(x -> System.out.print(x + "; "));
        System.out.println();
        Files.lines((Paths.get("c:/000/words.txt")))
                .parallel()
//                .filter(e -> e.length() > 4)
//                .sorted()
                .collect(Collectors.toList())
                .forEach(e -> System.out.print(e + "; "));
    }

    private static void testStreamIterator(int limit) {
        Stream.iterate(1, e -> e * 3).limit(limit).forEach(e -> System.out.printf("%,d\n", e));
    }

    private static void testStreamGenerator(int limit) {
        Stream.generate(Math::random).limit(limit).forEach(System.out::println);
    }

    private static <T> void testStreamGeneratorSupplier(int limit, Supplier<T> supplier) {
        Stream.generate(supplier)
//                .parallel()
                .limit(limit).forEach(x -> System.out.print(x + ", "));
    }

    private static void partitionByIncome() {
        Map<Boolean, List<Employee2>> collectedEmployees = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 70_000));
        System.out.println("...Poor employees...");
        System.out.println(collectedEmployees.get(false));
        System.out.println("...Rich employees...");
        System.out.println(collectedEmployees.get(true));
    }

    private static <R> void groupByCriterion(Function<Employee2, R> function) {
        Map<R, List<Employee2>> collectedEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(function));
//        collectedEmployees.keySet().stream().forEach(System.out::println);
        collectedEmployees.keySet().stream()
                .forEach(e -> System.out.println(e + "\n" + collectedEmployees.get(e)));

    }

    private static void testSortAndReduce() {
/*
        Employee2 employee1 = employeeList.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).get();
        System.out.println(employee1);
*/
/*
        Employee2 employee2 = employeeList.stream()
                .min(Comparator.comparingInt(Employee2::getSalary)).get();
        System.out.println(employee2);
*/
/*
        employeeList.stream()
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .distinct()
//                .sorted(Comparator.comparing(Employee2::getFirstName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
*/
/*
        Employee2 identity = new Employee2(0, "", "", 0);
        Employee2 reduceEmployee2 = employeeList.stream()
                .reduce(identity, (e1, e2) -> {
                    e1.setId(e1.getId() + e2.getId());
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    return e1;
                });
        System.out.println(reduceEmployee2);
*/
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
                .skip(2)
                .limit(1)
                .forEach(System.out::println);

/*
        Optional<Employee2> first = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .findFirst();
        System.out.println(first);
*/
/*
        OptionalDouble average = Stream.of(ids)
                .map(StreamsOverviewMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee2::getSalary)
                .average();
        System.out.println(average);
*/

        List<List<Employee2>> departments = new ArrayList<>();
        departments.add(employeeList);
        departments.add(secondList);

/*
        departments.stream().flatMap(l -> l.stream()
                .map(e -> e.getFirstName())).forEach(System.out::println);
*/

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

    private static void testStreamFromFile() throws IOException {
        Files.lines(
                (Paths.get("c:/000/words.txt")))
//                (Paths.get("src/com/javacode/streams/StreamsOverviewMain1.java")))
                .filter(e -> e.length() > 5)
                .map(String::toUpperCase)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList())
//                .collect(Collectors.toSet())
//                .collect(Collectors.toCollection(ArrayList::new))
//                .collect(Collectors.toCollection(LinkedList::new))
//                .collect(Collectors.toCollection(Stack::new))
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println);
    }

    private static Employee2 findById(int id) {
        if (Employee2Map == null) {
            Employee2Map = employeeList.stream()
                    .distinct()
                    .collect(Collectors.toMap(Employee2::getId, e -> e));
        }
        return Employee2Map.get(id);
    }
}
