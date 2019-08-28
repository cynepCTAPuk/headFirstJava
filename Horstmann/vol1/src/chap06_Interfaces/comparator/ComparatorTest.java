package chap06_Interfaces.comparator;

import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {
        var people = new ArrayList<Person>();
        people.add(new Person("Johnathan", "Forest", 37));
        people.add(new Person("Billy", "White", 21));
        people.add(new Person("Mary", "Song", 21));
        people.add(new Person("Anna", "Carpenter", 43));
        people.add(new Person("Tom", "Bear", 28));

        Collections.sort(people, Comparator.comparing(Person::getAge)
                .thenComparing(Person::getLastName));
        System.out.println(people);

//        Collections.sort(people, Comparator.comparing(Person::getFirstName,
//                (a, b) -> Integer.compare(a.length(), b.length())));
        Collections.sort(people, Comparator.comparingInt(p -> p.getFirstName().length()));
        System.out.println(people);

        Collections.sort(people,Comparator.comparing(Person::getLastName,
                Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println(people);
    }
}
