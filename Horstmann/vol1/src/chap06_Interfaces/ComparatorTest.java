package chap06_Interfaces;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] strings = {"a", "bb", "ccc"};
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(strings));
    }
}
