package chap11;

import java.util.*;

public class Exercise27 {
    static void fill(Queue<Command> queue) {
        queue.offer(new Command("first"));
        queue.offer(new Command("second"));
        queue.offer(new Command("third"));
        queue.offer(new Command("forth"));
    }

    public static void main(String[] args) {
        Queue<Command> queue = new LinkedList<>();
        fill(queue);
        while (queue.peek() != null) queue.remove().operation();
    }
}
