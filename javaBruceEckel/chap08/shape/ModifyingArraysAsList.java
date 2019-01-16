package chap08.shape;
//: holding/ModifyingArraysAsList.java
import java.util.*;
public class ModifyingArraysAsList {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("List<Integer> list1 = new ArrayList<>(Arrays.asList(ia))");
        System.out.println("list1 Before shuffling: " + list1);
        Collections.shuffle(list1, rand);
        System.out.println("list1 After shuffling: " + list1);
        System.out.println("array: " + Arrays.toString(ia));

        System.out.println();

        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("List<Integer> list2 = Arrays.asList(ia)");
        System.out.println("list2 Before shuffling: " + list2);
        Collections.shuffle(list2, rand);
        System.out.println("list2 After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));
    }
} /* Output:
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [4, 6, 3, 1, 8, 7, 2, 5, 10, 9]
array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
After shuffling: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
*///:~