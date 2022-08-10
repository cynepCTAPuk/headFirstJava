package t22;

import java.util.ArrayList;

public class Q220207_1 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(2);
        System.out.println(array);
        array.add(5);
        System.out.println(array);
        array.add(6);
        System.out.println(array);
        array.add(1, 7);
        System.out.println(array);
        System.out.println(array.indexOf(6));
        array.remove(1);
        System.out.println(array);
        System.out.println(array.indexOf(6));
    }
}

