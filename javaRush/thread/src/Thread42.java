import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Thread42 {

    public static void main(String[] args) {
        // Supplier — поставщик. Он не имеет параметров, но возвращает что-то, то есть поставляет это.
        Supplier<String> supplier = () -> "String"; // get()
        // Consumer — потребитель. Он принимает на вход что-то (параметр s) и с этим что-то что-то делает, то есть потребляет что-то.
        Consumer<String> consumer = s -> System.out.println(s); // accept()
        // Функция принимает на вход что-то (параметр s), что-то делает и возвращает что-то.
        Function<String, Integer> converter = s -> Integer.valueOf(s); // apply()
    }
}
