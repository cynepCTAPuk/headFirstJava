package chap7_adapter;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
/*
        System.out.println(list);
        IteratorAdapter enit = new IteratorAdapter(list);
        while (enit.hasMoreElements()) {
            System.out.println(enit.nextElement());
        }
*/
    }

}

