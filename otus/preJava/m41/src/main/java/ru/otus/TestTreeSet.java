package ru.otus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class TestTreeSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        set.add("First");
        set.add("Second");
        set.add("Third");
        set.add("Forth");
//        System.out.println(set);

        Set<Person> people = new TreeSet<>();
        people.add(new Person("First", 20));
        people.add(new Person("Second", 25));
        people.add(new Person("Third", 22));
        people.add(new Person("Forth", 18));
/*
        System.out.println(Arrays.asList(people));
        TestArrayList.printCollection(people);
        people.stream().forEach(e -> System.out.println("Name: " + e.getName() + ",\t Age: " + e.getAge()));
*/
        Set<Person> personTreeSet = new TreeSet<Person>();
        personTreeSet.add(new Person("First", 20));
        personTreeSet.add(new Person("Second", 25));
        personTreeSet.add(new Person("Third", 22));
        personTreeSet.add(new Person("Forth", 18));
        people.stream().forEach(e -> System.out.println("Name: " + e.getName() + ",\t Age: " + e.getAge()));
//        people.stream().filter(e -> e.getAge() < 21 & e.getAge() > 19).forEach(e -> System.out.println("Name: " + e.getName() + ",\t Age: " + e.getAge()));
    }
}
