package chap02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 5, 7, 9, 8, 6, 4, 2);
        integers.stream()
                .filter(s -> s % 3 == 0)
                .forEach(System.out::print);

        System.out.println();

        System.out.println(getNamesOfLength(2, "ab", "cad", "ef"));

        String[] names = {"Mal", "Wash", "Kaylee", "Inara", "Zoё", "Jayne", "Simon", "River", "Shepherd Book"};
        System.out.println(getNamesOfLength(5, names));
        System.out.println(getNamesStartingWith("S", names));
        System.out.println(getNamesSatisfyingCondition(s -> s.length() == 5, names));
        System.out.println(getNamesSatisfyingCondition(s -> s.startsWith("S"), names));
    }

    public static String getNamesOfLength(int length, String... names) {
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }

    public static String getNamesStartingWith(String str, String... names) {
        return Arrays.stream(names)
                .filter(s -> s.startsWith(str))
                .collect(Collectors.joining(", "));
    }

    public static String getNamesSatisfyingCondition(Predicate<String> condition, String... names) {
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }
}
