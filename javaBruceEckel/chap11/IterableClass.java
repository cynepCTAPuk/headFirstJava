//: holding/IterableClass.java
// Anything Iterable works with foreach.
package chap11;
import java.util.*;
public class IterableClass implements Iterable<String> {
    protected String[] words = (
            "And that is how we know the Earth to be banana-shaped.").split(" ");

    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;
            public boolean hasNext() { return index < words.length; }
            public String next() { return words[index++]; }
            // Not implemented
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    public static void main(String[] args) {
        for(String s : new IterableClass()) System.out.print(s + " ");
    }
} /* Output:
And that is how we know the Earth to be banana-shaped.
*///:~