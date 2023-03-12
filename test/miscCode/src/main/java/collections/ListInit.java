package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListInit {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) list.add(i);
		System.out.println(list.getClass());
		System.out.println(list);
		Collections.fill(list, 1);
		System.out.println(list);

		System.out.println("-".repeat(30));
		List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");  // Immutable collection
		System.out.println(places.getClass());
		System.out.println(places);
		places.set(0, "Rome");
//        places.add("London"); // UnsupportedOperationException
		System.out.println(places);

		System.out.println("-".repeat(30));
		places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
		System.out.println(places.getClass());
		System.out.println(places);
		places.add("London");
		System.out.println(places);

		List<String> subList = places.subList(1, places.size() - 1);
		System.out.println(subList + " - sublist(from, to)");
        places.subList(1, places.size() - 1).clear();
        System.out.println(places + " - sublist(from, to).clear()");

		System.out.println("-".repeat(30));
		List<Integer> theNumbers = Arrays.asList(4, 8, 15, 16, 23, 42);
		int size = theNumbers.size();
		for (Integer number : theNumbers.subList(0, size - 1)) System.out.print(number + ", ");
		System.out.println(theNumbers.get(size - 1));
	}
}
