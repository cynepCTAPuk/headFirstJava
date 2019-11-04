package chap01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StaticMethodDemo {
    public static void main(String[] args) {
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");
        System.out.println(bonds);
        List<String> sorted;

        sorted = bonds.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(sorted + " naturalOrder()");// [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]
        sorted = bonds.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorted + " reverseOrder()");// [Moore, Lazenby, Dalton, Craig, Connery, Brosnan]
        sorted = bonds.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());
        System.out.println(sorted + " String::toLowerCase");// [Brosnan, Connery, Craig, Dalton, Lazenby, Moore]
        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sorted + " String::length");// [Moore, Craig, Dalton, Connery, Lazenby, Brosnan]
        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(sorted + " String::length then naturalOrder()");
        // [Craig, Moore, Dalton, Brosnan, Connery, Lazenby]
    }
}
