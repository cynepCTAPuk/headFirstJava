package string;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class ToStringTest {
	public static void main(String[] args) {
		Cat cat = new Cat("Vaska");
		String text = "My cat is " + cat;
		System.out.println(text);

		text = '\u0f0f' + " Log";
		System.out.println(text);

		System.out.println((int) ' ');

		text = "Object is " + (float) 2 / 3;
		System.out.println(text);
	}
}

@AllArgsConstructor
@ToString
class Cat {
	private String name;
}
