package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Kotlin", "JavaScript");

        Predicate<String> predicate1 = str -> str.equals("Kotlin");
        System.out.println(list.stream().filter(predicate1).count());
        System.out.println(list.stream().filter(predicate1).collect(Collectors.joining(", ")));

        Predicate<String> predicate2 = a -> a.startsWith("Java");
        System.out.println(list.stream().filter(predicate2).collect(Collectors.joining(", ")));

        Predicate<String> predicate3 = a -> a.endsWith("Script");
        System.out.println(list.stream().filter(predicate2.and(predicate3)).collect(Collectors.joining(", ")));
    }
}
