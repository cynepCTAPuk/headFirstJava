/**
 * https://en.wikipedia.org/wiki/ANSI_escape_code
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 * https://dev.to/awwsmm/coloured-terminal-output-with-java-57l3
 */
package collections;

import java.util.Arrays;

public class ListTest1 {
    public static void main(String[] args) {
        String[] stringArr = {"Java", "fill", "the", "gaps"};
        var stringList = Arrays.asList(stringArr);
        System.out.println(stringList.contains("Java"));

        int[] intArray = {1, 2, 3};
        var intList = Arrays.asList(intArray);
        System.out.println(intList.contains(1));
    }
}



