//https://habr.com/ru/companies/jugru/articles/663220/
package stream;

import java.util.List;

public class MapMultiTest {
	public static void main(String[] args) {
		List<String> list = List.of("hello", "world");
		list.stream()
				.<Character>mapMulti((str, sink) -> {
					for (char c : str.toCharArray()) sink.accept(c);
				})
				.forEach(System.out::print);
		System.out.println();
		list.stream()
				.flatMap(s -> s.chars().mapToObj(c -> (char) c))
				.forEach(System.out::print);
	}
}
