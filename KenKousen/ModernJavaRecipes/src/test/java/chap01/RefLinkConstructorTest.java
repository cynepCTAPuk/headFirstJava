package chap01;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


public class RefLinkConstructorTest {
    @Test
    public void listToStream() {
        Person before = new Person("Grace Hopper");
        List<Person> people = Stream.of(before).collect(Collectors.toList());
        Person after = people.get(0);
        assertTrue(before == after);
        before.setName("Grace Murray Hopper");
        assertEquals("Grace Murray Hopper", after.getName());
    }

    @Test
    public void copyConstructor() {
        Person before = new Person("Grace Hopper");
        List<Person> people = Stream.of(before)
                .collect(Collectors.toList());
        Person after = people.get(0);
        assertEquals(before, after);

        people = Stream.of(before)
                .map(Person::new)
                .collect(Collectors.toList());
        System.out.println(people);
        after = people.get(0);

        assertFalse(before == after);

        before.setName("Rear Admiral Dr. Grace Hopper");
        assertFalse(before.equals(after));
    }

    @Test
    public void varargConstructor() {
        List<String> names = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");
        List<Person> people = names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());
        for (Person p : people) System.out.println(p.getName());
    }

    @Test
    public void arrayConstructor() {
        List<String> names = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spärck Jones");
        Person[] people = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
        for (Person p : people) System.out.println(p.getName());
    }
}
