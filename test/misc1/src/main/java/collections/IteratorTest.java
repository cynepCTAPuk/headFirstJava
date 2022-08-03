package collections;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str);
        String[] strings = str.split("");
        List<String> list = Arrays.asList(strings);
        ListIterator<String> listIterator = list.listIterator(list.size());
        StringBuilder reverseStr = new StringBuilder();
        while (listIterator.hasPrevious()) reverseStr.append(listIterator.previous());
        System.out.println(reverseStr);
        System.out.println(new StringBuilder(str).reverse());

        System.out.println(Integer.MAX_VALUE);
        System.out.println((int) Math.pow(2, 31));
        System.out.println(Long.MAX_VALUE);
        System.out.println((long) Math.pow(2, 63));
    }
}
