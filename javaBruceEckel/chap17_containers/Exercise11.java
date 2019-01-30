package chap17_containers;

import java.util.*;

class Ex11 implements Comparable {
    Random rnd = new Random();
    public Integer i = rnd.nextInt(100);
    public int hashCode() { return i; }
    public String toString() {return i + ""; }
    public int compareTo(Object o) {
        return i < o.hashCode() ? 1 : (i == o.hashCode() ? 0 : -1);
    }
}


public class Exercise11 {
    public static void main(String[] args) {
        PriorityQueue<Ex11> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 5 ; i++) priorityQueue.offer(new Ex11());
        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
    }
}
