package stream.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dictionary> dictionaries = Arrays.asList(
                new Dictionary(1, "one"),
                new Dictionary(2, "two"),
                new Dictionary(3, "three"));
        List<Dictionary> dictionaries1 = Arrays.asList(
                new Dictionary(1, "один"),
                new Dictionary(2, "два"),
                new Dictionary(3, "три"));
        List<Book> books = new ArrayList<>();
        for (Dictionary dictionary : dictionaries) books.add(new Book("A1", dictionary));
        for (Dictionary dictionary : dictionaries1) books.add(new Book("A2", dictionary));
        System.out.println(books);

        int n = 4;
        for (int i = 1; i < n; i++) System.out.println(getDescriptionFromBookAndItem(books, "A1", i));
        for (int i = 1; i < n; i++) System.out.println(getDescriptionFromBookAndItem(books, "A2", i));
    }

    private static String getDescriptionFromBookAndItem(List<Book> books, String book, Integer value) {
        Book b = books.stream()
                .parallel()
                .filter(a -> a.getName().equals(book) && a.getDictionary().getItem().equals(value))
                .findFirst()
                .orElse(new Book("--", new Dictionary(0, "--")));
        return b.getDictionary().getDescription();
    }
}
