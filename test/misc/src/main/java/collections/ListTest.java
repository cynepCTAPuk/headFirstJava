/**
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 * https://dev.to/awwsmm/coloured-terminal-output-with-java-57l3
 */
package collections;

import java.util.*;

import static util.PrintColor.*;

public class ListTest {
    public static void main(String[] args) {
        List<Person> arrayList = new ArrayList<>();
        Person person1 = new Person("One");
        Person person2 = new Person("Two");
        Person person3 = new Person("Three");
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(1, person3);

        System.out.print(ANSI_RED + "ForEach: ");
        System.out.print(ANSI_RESET);
        for (Person person : arrayList) System.out.print(person + " ");
        System.out.println();

        System.out.print(ANSI_BLUE + "Iterator: ");
        System.out.print(ANSI_RESET);
        Iterator<Person> iterator = arrayList.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");

        System.out.println();
        List<Integer> integerList = new LinkedList<>();
        System.out.println(integerList);

        Collections.addAll(integerList, 4, 8, 15, 16, 23, 42);
        integerList = new LinkedList<>(Arrays.asList(4, 8, 15, 16, 23, 42));
        integerList.add(3);
        System.out.println(integerList);

        integerList = Arrays.asList(4, 8, 15, 16, 23, 42);      // immutable list
        System.out.println(integerList);

        integerList = Collections.emptyList();                  // immutable list
        System.out.println(integerList);
    }

     static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + '}';
        }
    }
}


