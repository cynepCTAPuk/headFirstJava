package com.example;

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "com.example.Person{" +
                "name='" + name + '\'' +
                '}';
    }
}