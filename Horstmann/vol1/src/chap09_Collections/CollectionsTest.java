/*
 * https://javarush.ru/groups/posts/524-khvatit-pisatjh-ciklih-top-10-luchshikh-metodov-dlja-rabotih-s-kollekcijami-iz-java8
 */
package chap09_Collections;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        numbers.forEach(e -> System.out.print(e + " "));                // 1:
        System.out.println();

        numbers.removeIf(e -> e > 5);                                   // 2:
        numbers.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Map<String, String> books = new HashMap<>();
        books.put("Война и мир", "Лев Толстой");
        books.put("Преступление и наказание", "Федор Достоевский");
        books.put("Философия Java", "Брюс Эккель");
        books.put("Братья Карамазовы", "Федор Достоевский");
        books.put("Властелин Колец", "Джон Толкиен");
        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));

//        System.out.println("-".repeat(60));
//        books.compute("Философия Java", (a, b) -> b + ", крутой чувак");                // 4:
//        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));

        System.out.println("-".repeat(60));
        books.computeIfAbsent("Гарри Поттер и узник Азкабана", b -> getHarryPotterAuthor()); // 5:
        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));

        System.out.println("-".repeat(60));
        books.computeIfPresent("Евгений Онегин", (a, b) -> b = "Александр Пушкин");     // 6:
        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));
//        System.out.println("-".repeat(60));
//        books.computeIfPresent("Братья Карамазовы", (a, b) -> b = "Александр Пушкин");  // 6:
//        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));

/*
        System.out.println("-".repeat(60));
        String igor = books.getOrDefault(
                "Слово о полку Игореве", "Неизвестный автор");            // 7:
        System.out.println(igor);
*/

//        System.out.println("-".repeat(60));
//        books.merge("Философия Java", "Брюс Эккель", (a, b) -> b + " и кто-то там еще"); // 8:
//        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));

        books.putIfAbsent("Властелин Колец", "Джон Толкин");            // 9:

        System.out.println("-".repeat(60));
//        books.replace("Братья Карамазовы", "Федор Достоевский", "Джон Толкиен");
        books.replaceAll((a, b) -> b = "Крутой писатель");              // 10.
        books.forEach((a, b) -> System.out.printf("Название: %-30s Автор: %s\n", a, b));
    }

    public static String getHarryPotterAuthor() {
        return "Джоан Роулинг";
    }
}
