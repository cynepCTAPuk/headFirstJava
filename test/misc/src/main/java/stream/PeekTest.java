package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekTest {
    public static void main(String[] args) {
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.print("Filtered value: " + e + " "))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("-".repeat(30));
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.forEach(System.out::println);

        System.out.println("-".repeat(30));
        Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
        userStream.peek(u -> u.setName(u.getName().toUpperCase())).forEach(System.out::println);
    }
}
