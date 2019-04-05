package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloWorld {
	String name;
	

	public HelloWorld(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorld [string=" + name + "]";
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
		
		System.out.println(new HelloWorld(" "));
		
		System.out.println("Hello World!");
	}
}