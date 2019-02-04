package chap10_innerclasses;

//: innerclasses/Sequence.java
// Holds a sequence of Objects.
interface Selector {
    Object current();
    boolean end();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public void add(Object obj) { if(next < items.length) items[next++] = obj; }

    private class SequenceSelector implements Selector {
        private int i = 0;
        public Object current() { return items[i]; }
        public boolean end() { return i == items.length; }
        public void next() { if(i < items.length) i++; }
        public Sequence outer(){ return Sequence.this; }
    }
    public Selector selector() { return new SequenceSelector(); }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++) sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
            if(selector.end()) System.out.println();
        }
        System.out.println(sequence);
        System.out.println(selector);
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~