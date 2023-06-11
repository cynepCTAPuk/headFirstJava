package collections;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		String[] strings = {"7", "5"};
		Queue<String> pq = new PriorityQueue<>(Arrays.asList(strings));
		System.out.println("pq=" + pq);
		pq.add("2");
		System.out.println("pq=" + pq + " - after pq.add(\"2\")");
		pq.add("4");
		System.out.println("pq=" + pq + " - after pq.add(\"4\")");
		String peek = pq.peek();
		System.out.println("pq=" + pq + " - after pq.peek()=" + peek);
		pq.offer("1");
		System.out.println("pq=" + pq + " - after pq.offer(\"1\")");
		pq.add("3");
		System.out.println("pq=" + pq + " - after pq.add(\"3\")");
		pq.remove("1");
		System.out.println("pq=" + pq + " - after pq.remove(\"1\")");
		String poll = pq.poll();
		System.out.println("pq=" + pq + " - after pq.poll()=" + poll);
		poll = pq.poll();
		peek = pq.peek();
		System.out.println("pq=" + pq + " - after pq.poll()=" + poll + " pq.peek()=" + peek);
	}
}
