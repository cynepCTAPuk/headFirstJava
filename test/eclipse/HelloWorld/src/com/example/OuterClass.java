/**
 * @author CTAPuk
 * 
 */
package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OuterClass {
	class InnerClass {
	}

	public static void main(String[] args) {

		String[] strings = { "a", "b", "c" };
		System.out.println(Arrays.toString(strings));

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);

		for (String s : strings) {
			System.out.printf("%s ", s);
		}
		System.out.println();

		System.out.println("Hello World!");
	}
}

class AnotherClass {
}