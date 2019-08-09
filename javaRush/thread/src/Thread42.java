import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Thread42 {

    public static void main(String[] args) {
        // Supplier — поставщик. Он не имеет параметров, но возвращает что-то,
        // то есть поставляет это.
        Supplier<Object> supplier = () -> "Поставляю то, что поставляю"; // get()
        System.out.println(supplier.get());

        // Consumer — потребитель. Он принимает на вход что-то (параметр s) и с этим
        // что-то что-то делает, то есть потребляет что-то.
        Consumer<String> consumer = s -> System.out.println(s); // accept()
        consumer.accept("Принимаю строку и печатаю её");

        // Функция принимает на вход что-то (параметр s), что-то делает и возвращает что-то.
        Function<String, Integer> converter = s -> Integer.valueOf(s); // apply()
        System.out.println(converter.apply("10") + 1);
        Function<String, String> convertToUpper = s -> s.toUpperCase();
        System.out.println(convertToUpper.apply("hello world"));
        Function<String, String> convertReverse = s -> new StringBuilder(s).reverse().toString();
        System.out.println(convertReverse.apply("hello world"));

        BiFunction<Integer, Integer, String> biFunction = (a, b) -> String.valueOf(a * b);
        System.out.println(biFunction.apply(11, 5));
    }
}
