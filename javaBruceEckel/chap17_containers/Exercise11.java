package chap17_containers;
import java.util.*;
class Ex11 implements Comparable<Ex11> {
    Random rnd = new Random();
    public Integer i = rnd.nextInt(100);
    public String toString() {return String.valueOf(i); }
    public int compareTo(Ex11 ex11) { return i < ex11.i ? 1 : (i == ex11.i ? 0 : -1); }
}

public class Exercise11 {
    public static void main(String[] args) {
        PriorityQueue<Ex11> pQueue = new PriorityQueue<>();
        for (int i = 0; i < 5 ; i++) pQueue.offer(new Ex11());
        System.out.println(pQueue);
        while (!pQueue.isEmpty()) System.out.print(pQueue.poll() + " ");
    }
}
