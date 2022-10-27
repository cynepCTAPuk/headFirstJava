package y21;

import java.util.ArrayList;
import java.util.List;

public class Q210612_1 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List tmp = integerList;
        tmp.add("1");
        tmp.add("value");
        System.out.println(tmp.get(0));
        System.out.println(tmp.get(1));
    }
}
