package chap7_adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter implements Enumeration {
    Iterator iterator;

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}

