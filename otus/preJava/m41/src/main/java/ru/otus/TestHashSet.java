package ru.otus;

import java.awt.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
/*
        Set<Point> points = new HashSet<>();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        points.add(p1);
        System.out.println(points.size() + " " + points);
        p2.setLocation(2, 2);
        points.add(p2);
        System.out.println(points.size() + " " + points);
        p2.setLocation(1, 1);
        System.out.println(points.size() + " " + points);
        p1.translate(1, 1);
        System.out.println(points);

        Set<String> set = new HashSet<>();
        set.add("First");
        set.add("Second");
        set.add("Third");
        set.add("Forth");
        System.out.println(set);
        for (String e : set) System.out.println(e + " " + e.hashCode());
*/

        Set<Person> people = new HashSet<>();
        people.add(new Person("First", 20));
        people.add(new Person("Second", 25));
        people.add(new Person("Third", 22));
        people.add(new Person("Forth", 18));
        people.stream().forEach(e -> System.out.println("Name: " + e.getName() + ",\t Age: " + e.getAge()));
        System.out.println(people.contains(new Person("First",21)));
    }
}
