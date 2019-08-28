package chap06_Interfaces.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        var people = new ArrayList<Person>();
        people.add(new Person("John", "Forest", 42));
        people.add(new Person("Bill", "White", 21));
        people.add(new Person("Mary", "Song", 21));
        people.add(new Person("Anna", "Carpenter", 33));
        people.add(new Person("Tom", "Bear", 19));

        System.out.println(people);

        Collections.sort(people, Comparator.comparing(Person::getAge)
                .thenComparing(Person::getLastName));
        System.out.println(people);
    }
}
