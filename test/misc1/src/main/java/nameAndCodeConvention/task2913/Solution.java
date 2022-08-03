package nameAndCodeConvention.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

/*
    public static String recursion(int a, int b) {
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }
*/

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

    private static String getAllNumbersBetween(int numberA, int numberB) {
        StringBuilder builder = new StringBuilder();
        if (numberA < numberB) {
//            System.out.println("A<B");
            for (int i = numberA; i < numberB; i++) {
                builder.append(i).append(" ");
            }
            builder.append(numberB);
        } else if (numberA > numberB) {
//            System.out.println("A>B");
            for (int i = numberA; i > numberB; i--) {
                builder.append(i).append(" ");
            }
            builder.append(numberB);
        } else {
//            System.out.println("A=B");
            builder.append(numberA);
        }
        return builder.toString();
    }
}