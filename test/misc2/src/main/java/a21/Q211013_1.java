package aaa;

import java.util.ArrayList;
import java.util.List;

public class Q211013_1 {
    public static void main(String[] args) {
        String s1 = "str";
        String s2 = "str";
        System.out.println("Result: " + s1 == s2);

        List<Double> list = new ArrayList();
        System.out.println(list.getClass());
        list = List.of(7.0, 8.0);
        System.out.println(list.getClass());
    }
}

