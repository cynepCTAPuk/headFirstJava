//: generics/IterableFibonacci.java
// Adapt the Fibonacci class to make it Iterable.
package chap15_generics;
import java.util.*;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int count) { n = count; }
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            public boolean hasNext() { return n > 0; }
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
            // Not implemented
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }
    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18)) System.out.print(i + " ");
        System.out.println();

        IterableFibonacci ifi = new IterableFibonacci(18);
        while(ifi.iterator().hasNext()) System.out.print(ifi.iterator().next() + " ");
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~