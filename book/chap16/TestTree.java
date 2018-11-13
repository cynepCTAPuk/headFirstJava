package chap16;

import java.util.ArrayList;
import java.util.TreeSet;

class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");

        ArrayList<Book> bookArrayList = new ArrayList<Book>();
        bookArrayList.add(b1);
        bookArrayList.add(b2);
        bookArrayList.add(b3);
        System.out.println(bookArrayList);

        TreeSet<Book> bookTreeSet = new TreeSet<Book>();
        bookTreeSet.add(b1);
        bookTreeSet.add(b2);
        bookTreeSet.add(b3);
        System.out.println(bookTreeSet);
    }
}

class Book implements Comparable<Book> {
    String title;

    Book(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.title);
    }
}