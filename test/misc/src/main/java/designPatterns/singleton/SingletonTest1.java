/**
 * Джошуа Блох 3-е издание
 * 5.5. Предпочитайте обобщенные методы
 */
package designPatterns.singleton;

import java.util.function.UnaryOperator;

public class SingletonTest1 {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    private static <T> UnaryOperator<T> identityFunctional() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryOperator<String> sameString = identityFunctional();
        for (String s : strings) System.out.println(sameString.apply(s));

        Number[] numbers = {1, 2.0, 3L};
        UnaryOperator<Number> sameNumber = identityFunctional();
        for(Number n: numbers) System.out.println(sameNumber.apply(n));
    }
}
