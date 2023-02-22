package stream;

import java.util.List;

public class PeekTest {
	public static void main(String[] args) {
		int s = 0;

		System.out.println(++s + " " + "-".repeat(30));
		List<User> users = List.of(new User("Alice", 10), new User("Bob", 16), new User("Chuck", 30));
		System.out.println(users);

		System.out.println(++s + " " + "-".repeat(30));
		List<User> users1 = users.stream()
				.peek(u -> {
					u.setName(u.getName().toUpperCase());
					u.setAge(u.getAge() + 1);
				})
				.toList();
		System.out.println(users1);
	}
}
