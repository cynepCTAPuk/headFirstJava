package ru.otus.exception;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static Person findPerson(String name) throws PersonNotFoundException {
        Person person = PersonCatalog.find(name);
        assert person != null;
        if (person.getName() == null) throw new PersonNotFoundException(name);
        return person;
    }

    public static void main(String[] args) {
/*
        Set<Person> people = new HashSet<>();
        people.add(new Person("First", 20));
        people.add(new Person("Second", 25));
        people.add(new Person("Third", 22));
        people.add(new Person("Forth", 18));
*/
/*
        try {
            Person person = findPerson("Ivanov");
            person.sendMessage("Where are you?");
        } catch (PersonNotFoundException e) {
            System.out.println("Person " + e.getName() + " not found!");
        }
*/

//        System.out.println(people.contains(new Person("First",10)));
        Exception e = new Exception();
    }

}
