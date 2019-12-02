package collections;

import unsort.Person;

import java.util.*;

public class ListTest {
    public static void main(String[] args)  {

        List<Person> arrayList = new ArrayList<>();
        Person person1 = new Person("One");
        Person person2 = new Person("Two");
        Person person3 = new Person("Three");
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(1, person3);

        System.out.print("\u001B[31mFor Each: ");
        for (Person person : arrayList) System.out.print(person + " ");
        Iterator iterator = arrayList.iterator();
        System.out.print("\n\u001B[34mIterator: ");
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");

        List<Person> linkedList = new LinkedList<>();
    }
}


