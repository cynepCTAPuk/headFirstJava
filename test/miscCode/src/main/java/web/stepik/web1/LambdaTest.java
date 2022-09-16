package web.stepik.web1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names);
/*
        Collections.sort(names);
        System.out.println(names);
        Collections.reverse(names);
        System.out.println(names);
*/

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
//        Collections.sort(names, (a, b) -> b.compareTo(a));
//        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
    }
}
