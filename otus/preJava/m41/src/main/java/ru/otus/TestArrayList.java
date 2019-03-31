package ru.otus;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> ArrayList1 = new ArrayList<>();
        ArrayList1.add("First");
        ArrayList1.add("Second");
        ArrayList1.add("First");
        System.out.println("ArrayList1: \t" + ArrayList1);

        ArrayList1.add(0, "VeryFirst");
        ArrayList1.addAll(ArrayList1);
        System.out.println("ArrayList1 addAll ArrayList1: \t" + ArrayList1);

//        ArrayList1.stream().forEach(e -> System.out.println("Length of " + e + " = " + e.length()));

        List<String> ArrayList2 = Arrays.asList("First","Second");
        System.out.println("ArrayList2: \t" + ArrayList2);

        ArrayList1.removeAll(ArrayList2);
        System.out.println("ArrayList1 removeAll ArrayList2: \t" + ArrayList1);

        ArrayList1.addAll(ArrayList2);
        System.out.println("ArrayList1 addAll ArrayList2: \t" + ArrayList1);
        ArrayList1.add(3, "Third");
        System.out.println("ArrayList1 add \"Third\" on 3rd position: \t" + ArrayList1);

        ArrayList1.removeIf(next -> next.equals("Second"));
        System.out.println("ArrayList1 remove \"Second\": \t" + ArrayList1);

        System.out.println("ArrayList1.stream().count(): "+ (long) ArrayList1.size());
        System.out.println("ArrayList2.stream().count(): "+ (long) ArrayList2.size());

    }

    public static void printCollection(Collection<?> c) {
        Iterator<Object> iterator = (Iterator<Object>) c.iterator();
        System.out.print("[");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (iterator.hasNext()) {
                System.out.print(next + " - ");
            } else System.out.println(next + "]");
        }
    }
}
