package functional;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> containsA = t -> t.contains("A");
        Predicate<String> containsB = t -> t.contains("B");
        Predicate<String> containsF = t -> t.contains("F");
        int i = 50;
        String abcd = "ABCD";
        System.out.print(containsA.test(abcd));
        System.out.println("-".repeat(i));
        System.out.print(containsA.negate().test(abcd));
        System.out.println("-".repeat(i));
        System.out.print(containsA.and(containsF).test(abcd));
        System.out.print(containsA.or(containsB).test(abcd));
        System.out.println("-".repeat(i));
        System.out.print(Predicate.not(containsA).test(abcd));
        System.out.print(Predicate.isEqual(containsA).test(containsA));
    }
}
