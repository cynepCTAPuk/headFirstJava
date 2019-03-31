package ru.otus.exception;

public class PersonNotFoundException extends Exception {
    String name;

    public PersonNotFoundException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
