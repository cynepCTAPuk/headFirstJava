package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamCollectorExamples {
	public static void main(String[] args) {
		Integer[] integers = {1, 2, 3, 4};
		Collection<Integer> numbers = Arrays.asList(integers);
		System.out.println("1. Суммируем нечётные числа: " +
				numbers.stream().collect(Collectors.summingInt((p -> p % 2 == 1 ? p : 0))));
		System.out.println("2. Вычисляем среднее предварительно вычитая 1 у каждого числа: " +
				numbers.stream().collect(Collectors.averagingInt(p -> p - 1)));
		System.out.println("3. summarizing: " +
				numbers.stream().collect(Collectors.summarizingInt(p -> p + 3)));
		System.out.println("4. Делим на две группы, чёт - нечёт " +
				numbers.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0)));
		System.out.println("-----");

		String[] strings = {"a1", "b2", "c3", "a1"};
		Collection<String> list = Arrays.asList(strings);
		System.out.println("1: " + list.stream().distinct().collect(Collectors.toList()));
		System.out.println("2: " + Arrays.toString(list.stream()
				.distinct().map(String::toUpperCase).toArray(String[]::new)));
		System.out.println("3: joining: " + list.stream()
				.collect(Collectors.joining(": ", "<b> ", " </b>")));
		System.out.println("4: toMap" + list.stream().distinct()
				.collect(Collectors.toMap(p -> p.substring(0, 1), p -> p.substring(1, 2))));
		System.out.println("5: " + list.stream()
				.collect(Collectors.groupingBy(p -> p.substring(0, 1))));
		System.out.println("6: " + list.stream().collect(
				Collectors.groupingBy(p -> p.substring(0, 1),
						Collectors.mapping(p -> p.substring(1, 2), Collectors.joining(":"))
				)));
		System.out.println("-----");

		System.out.println(String.join(" ", strings));
		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.stream(strings).collect(Collectors.joining("; ", "(", ")")));
	}
}
