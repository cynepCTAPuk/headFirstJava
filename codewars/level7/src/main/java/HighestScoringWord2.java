import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord2 {
    public static String high(String s) {
        return Arrays
                .stream(s.split(" "))
                .max(Comparator.comparingInt(a -> a.chars().map(i -> i - 96).sum()))
                .get();
    }
}