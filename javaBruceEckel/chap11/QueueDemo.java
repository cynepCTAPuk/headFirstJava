package chap11;

//: holding/QueueDemo.java
// Upcasting to a Queue from a LinkedList.
import java.util.*;

import static util.Print.print;

public class QueueDemo {
    public static void printQ(Queue queue) {
        while(queue.peek() != null) System.out.print(queue.remove() + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Random rand = new Random(47);

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < 10; i++) queue.offer(rand.nextInt(i + 10));
        print(queue.size());
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();
        for(char c : "Brontosaurus".toCharArray()) qc.offer(c);
        print(qc.size());
        printQ(qc);
    }
} /* Output:
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*///:~