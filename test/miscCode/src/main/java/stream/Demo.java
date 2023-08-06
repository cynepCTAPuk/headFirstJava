package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Java 8
 * List<String> list = Arrays.asList("a1", "b2", "c3"); // fix size
 * List<String> list = new ArrayList<>() {{add("a1");add("b2");add("c3");}};
 * List<String> list = new ArrayList<>(Arrays.asList("a1", "b2", "c3"));
 * List<String> list = Stream.of("a1", "b2", "c3").collect(Collectors.toList());
 * Java 9 fix size
 * List<String> list = List.of("a1", "b2", "c3");
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println(getIntegers());

		List<String> list = new ArrayList<>(); // Java 8
		Collections.addAll(list, "0a1", "_b2", "c3");
		list.add("d4");
		System.out.println(getResultImperative(list));
		System.out.println(getResultDeclarative(list));
	}

	private static List<Integer> getIntegers() {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		return Stream
				.generate(atomicInteger::getAndIncrement)
//                .iterate(0, i -> i + 1)
				.limit(10)
				.toList();
	}

	private static int getResultImperative(List<String> strings) {
		return strings.stream().
				filter(string -> !Character.isDigit(string.charAt(0)))
				.filter(string -> !string.contains("_"))
				.mapToInt(String::length)
				.sum();
	}

	private static int getResultDeclarative(List<String> strings) {
		return strings.stream().
				filter(s -> !Character.isDigit(s.charAt(0))).
				filter(s -> !s.contains("_")).
				mapToInt(String::length).
				sum();
	}
}
