package regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitTest {
    public static void main(String[] args) {
        String number = "+38(050)123-45-67";
        System.out.println(String.join("",number.split("[-()]")));
        System.out.println(number.replaceAll("[^0-9]", ""));
        System.out.println(number.replaceAll("\\D", ""));
        System.out.println(number.replaceAll("[^\\d]", ""));

        int[] ints = {1, 2, 3, 4};
        List<Integer> list = new ArrayList<>();
        for(int i:ints) list.add(i);
        System.out.println(list);
    }
}
