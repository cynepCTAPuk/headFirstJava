import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Thread42 {

    public static void main(String[] args) {
        // Supplier — поставщик. Он не имеет параметров, но возвращает что-то, то есть поставляет это.
        Supplier<String> supplier = () -> "string"; // get()
        System.out.println(supplier.get());

        // Consumer — потребитель. Он принимает на вход что-то (параметр s) и с этим что-то что-то делает, то есть потребляет что-то.
        Consumer<String> consumer = System.out::println; // accept()
        consumer.accept("Hello World!");

        // Функция принимает на вход что-то (параметр s), что-то делает и возвращает что-то.
        Function<String, Integer> converter = Integer::valueOf; // apply()
        System.out.println(converter.apply("10") + 1);
        Function<String, String> convertToUpper = String::toUpperCase; // apply()
        System.out.println(convertToUpper.apply("hello world"));

        BiFunction<Integer, Integer, String> biFunction = (a, b) -> String.valueOf(a + b);
        System.out.println(biFunction.apply(10, 5));
    }
}
