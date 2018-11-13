package chap06;

import java.util.ArrayList;

public class TestArrayList {

    private static ArrayList<String> books = new ArrayList();

    private static void printAL(ArrayList list) {
        System.out.print(list.size() + " ");
        System.out.println(list);
    }

    public static void main(String[] args) {
        books.add("one");
        books.add("two");
        books.add("three");
        books.add("four");
        books.add("five");
        books.add("six");

        printAL(books);
        books.remove("two");
        printAL(books);
        books.add(1, "two");
        printAL(books);
        books.add(null);
        books.add(null);
        printAL(books);
        books.set(7,"seven");
        printAL(books);
        books.remove(6);
        printAL(books);
    }
}
