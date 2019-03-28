package com.javacode.lambdas;

class Person {
    String firstName;
    String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

public class FunctionalInterface3 {
    public static void main(String[] args) {
//        PersonFactory<Person> personFactory =
//                (firstName, lastName) -> new Person(firstName, lastName);
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        Person person1 = new Person();
        System.out.println(person);
        System.out.println(person1);
    }
}
