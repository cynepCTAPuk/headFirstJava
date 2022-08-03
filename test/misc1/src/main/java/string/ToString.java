package string;

import java.util.Arrays;

public class ToString {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        System.out.println(String.valueOf(chars));
        System.out.println(Arrays.toString(chars));
        String str = null;
        System.out.println(String.valueOf(str));
        Double dbl = null;
        System.out.println(String.valueOf(dbl));

        Integer i = 100;
        System.out.println(String.valueOf(i));
        System.out.println(Integer.toString(i));
    }
}
