package ru.otus.l71.creational.bilder;

/**
 * Created by tully.
 * <p>
 * Director in the Builder pattern.
 */
public class Main {
    public static void main(String... args) {
        BookInfoBuilder builder = new BookInfoBuilderImpl();
        BookInfo info = builder.setAuthor("Tully")
                .setName("Java before and after")
                .setEdition(1)
                .build();
//        System.out.println(info);

        BookInfoBuilder builder1 = new BookInfoBuilderImpl();
        BookInfo info1 = new BookInfo("A", "N", 1, 11);
        System.out.println(info1);

        info1 = builder1
                .setAuthor("B")
//                .setAuthor("C")
                .setName("O")
                .setEdition(2)
                .setIndex(22)
                .build();
        System.out.println(info1);

        BookInfoBuilder builder2 = new BookInfoBuilderImpl();
//        BookInfo info2 = builder2.build();
//        System.out.println(info2);
    }
}
