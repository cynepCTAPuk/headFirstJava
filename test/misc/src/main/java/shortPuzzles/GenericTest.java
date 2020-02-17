package shortPuzzles;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List longs = new ArrayList<Long>();
        longs.add(1L);
        longs.add(1.0);
        longs.add(new Object());
        longs.add("I am LONG!!!");
        System.out.println(longs.size()); // 4
    }
}
