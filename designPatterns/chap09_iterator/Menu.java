package chap09_iterator;

import java.util.Iterator;

public interface Menu {
    public Iterator<MenuItem> createIterator();
}
