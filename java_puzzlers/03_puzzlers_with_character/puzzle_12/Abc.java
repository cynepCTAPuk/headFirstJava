package puzzle_12;

import java.util.Arrays;

public class Abc {
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = { '1', '2', '3' };
        System.out.println(letters + " easy as " + numbers);

        System.out.println(letters + " easy as " + String.valueOf(numbers));
        System.out.print(letters + " easy as ");
        System.out.println(numbers);
        System.out.println(letters + " easy as " + Arrays.toString(numbers));
    }
}
