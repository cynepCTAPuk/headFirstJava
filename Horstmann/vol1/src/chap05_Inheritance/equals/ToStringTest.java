package chap05_Inheritance.equals;

import java.util.Arrays;

public class ToStringTest {
    public static void main(String[] args) {
        System.out.println(System.out);

        int[] luckyNumbers = {2, 3, 5, 7, 11, 13};
        System.out.println(luckyNumbers);
        System.out.println(Arrays.toString(luckyNumbers));
    }
}
