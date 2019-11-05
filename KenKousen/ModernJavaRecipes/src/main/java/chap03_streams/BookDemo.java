package chap03_streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Modern Java Recipes"));
        books.add(new Book(2, "Making Java Groovy"));
        books.add(new Book(3, "Gradle Recipes for Android"));

        HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(), // 
                        (map, book) -> { // 
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> { // 
                            map1.putAll(map2);
                            return map1;
                        });
        bookMap.forEach((k, v) -> System.out.println(k + ": " + v));
        //  Нейтральное значение для putAll
        //  Поместить одну книгу в Map методом put
        //  Объединить две структуры Map методом putAll
    }
}
