package string;

import java.util.Arrays;
import java.util.List;

public class JoinTest {
    public static void main(String[] args) {
        String string = String.join(", ", "a1", "b1", "c1");
        System.out.println(string);
        List<String> list = Arrays.asList("a2", "b2", "c2");
        string = String.join(", ", list);
        System.out.println(string);
    }
}
