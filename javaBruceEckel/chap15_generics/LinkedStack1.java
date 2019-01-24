//: generics/LinkedStack.java
// A stack implemented with an internal linked structure.
package chap15_generics;
public class LinkedStack1<T> {
    private static class Node {
        T item;
        Node next;
        Node() { item = null; next = null; }
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
        boolean end() { return item == null && next == null; }
    }

    private Node top = new Node(); // End sentinel

    public void push(T item) { top = new Node(item, top); }
    public T pop() {
        T result = top.item;
        if(!top.end()) top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack1<String> lss = new LinkedStack1<>();
        for(String s : "Phasers on stun!".split(" ")) lss.push(s);
        String s;
        while((s = lss.pop()) != null) System.out.println(s);
    }
} /* Output:
stun!
on
Phasers
*///:~