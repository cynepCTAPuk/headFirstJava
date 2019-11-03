package chap01;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Person p) {
        this.name = p.name;
    }

    public Person(String... names) {
        this.name = Arrays.stream(names).collect(Collectors.joining(" "));
        System.out.println("Varargs const, names=" + Arrays.asList(names));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
