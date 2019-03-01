package puzzle_23;
import java.util.*;

public class Rhymes2 {
    private static Random rnd = new Random();
    private static String randomElement(String[] a) {
        return a[rnd.nextInt(a.length)];
    }

    public static void main(String args[]) {
        String a[] = {"Main", "Pain", "Gain"};
        for (int i = 0; i < 10; i++) System.out.println(randomElement(a));
    }
}