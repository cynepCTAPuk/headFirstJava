package chap04;

import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        Random random = new Random();
        Random random1 = new Random();
        int one = random.nextInt(10);
        int two;
        System.out.println(one);
        while (true) {
            two = random1.nextInt(10);
            if (two > one) {
                System.out.print(two + "> ");
            } else {
                if (two == one) {
                    System.out.print(two + "= ");
                } else System.out.print(two + "< ");
            }
        }
    }
}
