package string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinTest {
	public static void main(String[] args) {
		String string = String.join(", ", "a1", "b1", "c1");
		System.out.println(string);
		List<String> list = Arrays.asList("a2", "b2", "c2");
		string = String.join(", ", list);
		System.out.println(string);
		String[] strings = {"a3", "b3", "c3"};
		String collectStrings = Arrays.stream(strings)
                .collect(Collectors.joining(", ", "[", "]"));
		System.out.println(collectStrings);
        Integer[] integers = {1, 2, 3};
        String collectIntegers = Arrays.stream(integers)
                .map(Object::toString)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(collectIntegers);
    }
}
