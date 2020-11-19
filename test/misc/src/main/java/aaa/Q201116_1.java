package aaa;

import java.util.ArrayList;

public class Q201116_1 {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);
    }
}
