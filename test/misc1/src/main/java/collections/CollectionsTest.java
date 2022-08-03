package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        System.out.println(list);
        Collections.fill(list, 0);
        System.out.println(list + "\n");

        List<String> places;
        places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");  // Immutable collection
        System.out.println(places.getClass());
        System.out.println(places);
        places.set(0, "Rome");
//        places.add("London"); // UnsupportedOperationException
        System.out.println(places + "\n");

        places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        System.out.println(places.getClass());
        System.out.println(places);
        places.add("London");
        System.out.println(places);
    }
}
