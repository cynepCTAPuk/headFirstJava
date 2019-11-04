package chap02;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SupplierDemo {
    public static void main(String[] args) {
/**
 *  Реализация с помощью анонимного внутреннего класса
 *  Лямбда-выражение
 *  Ссылка на метод
 */
        Logger logger = Logger.getLogger("...");
        DoubleSupplier randomSupplier;
        randomSupplier = new DoubleSupplier() { // 
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        randomSupplier = () -> Math.random(); // 
        randomSupplier = Math::random; // 
        logger.info(String.valueOf(randomSupplier));
        System.out.println(logger);
/**
 *  Печатается Optional.empty
 *  Печатается строка "None"
 *  Коллекция с запятой-разделителем строится, даже если имя найдено
 *  Коллекция с запятой-разделителем строится, только когда Optional пусто
 */
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoё", "Jayne", "Simon", "River", "Shepherd Book");
        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();
        System.out.println(first); // 

        System.out.println(first.orElse("None")); // 

        System.out.println(first.orElse(String.format("Ничего не найдено в %s",
                names.stream().collect(Collectors.joining(", "))))); // 

        System.out.println(first.orElseGet(() -> String.format("Ничего не найдено в %s",
                names.stream().collect(Collectors.joining(", ","[","]"))))); // 
    }
}
