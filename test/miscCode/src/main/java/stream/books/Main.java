package stream.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        for (Dictionary dictionary : Arrays.asList(new Dictionary(1, "one"), new Dictionary(2, "two"), new Dictionary(3, "three")))
            books.add(new Book("A1", dictionary));
        for (Dictionary dictionary : Arrays.asList(new Dictionary(1, "один"), new Dictionary(2, "два"), new Dictionary(3, "три")))
            books.add(new Book("A2", dictionary));
        System.out.println(books);

        String result;
        for (int i = 1; i < 5; i++) {
            result = getDescriptionFromBookAndItem(books, "A1", i);
            System.out.println(result);
            result = getDescriptionFromBookAndItem(books, "A2", i);
            System.out.println(result);
        }
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
