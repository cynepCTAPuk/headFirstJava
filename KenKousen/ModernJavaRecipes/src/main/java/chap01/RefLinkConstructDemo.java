package chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RefLinkConstructDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person alice = new Person("Alice");
        Person john = new Person("John");
        people.add(alice);
        people.add(john);

        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        List<String> names1 = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");
        List<Person> people1 = names1.stream().map(Person::new).collect(Collectors.toList());
        for (Person p : people1) System.out.println(p.getName());



    }

}
