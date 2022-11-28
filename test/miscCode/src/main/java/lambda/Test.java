package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four");
        System.out.println(list);
//        list.sort(String::compareTo);
        list.sort(Collections.reverseOrder());
        System.out.println(list);

    }
}
