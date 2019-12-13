/**
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 * https://dev.to/awwsmm/coloured-terminal-output-with-java-57l3
 */
package collections;

import unsort.Person;

import java.util.*;

public class ListTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        List<Person> arrayList = new ArrayList<>();
        Person person1 = new Person("One");
        Person person2 = new Person("Two");
        Person person3 = new Person("Three");
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(1, person3);

        System.out.print(ANSI_RED + "ForEach: ");
        for (Person person : arrayList) System.out.print(person + " ");

        System.out.print(ANSI_BLUE + "\nIterator: ");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");

        System.out.print(ANSI_RESET + "\n");

        List<Integer> theNumbers = new LinkedList<Integer>();

        Collections.addAll(theNumbers, 4, 8, 15, 16, 23, 42);
        theNumbers = new LinkedList<Integer>(Arrays.asList(4, 8, 15, 16, 23, 42));
        theNumbers = Arrays.asList(4, 8, 15, 16, 23, 42); // immutable list
    }
}


