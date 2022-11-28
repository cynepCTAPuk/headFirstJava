package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Kotlin", "JavaScript");

        Predicate<String> predicate1 = "Java"::equals;
        System.out.println(list.stream().filter(predicate1).count());
        Predicate<String> predicate2 = "Kotlin"::equals;
        System.out.println(list.stream().filter(predicate2).count());

        String java = list.stream().filter(a -> a.startsWith("Java")).collect(Collectors.joining(", "));
        System.out.println(java);
    }
}
