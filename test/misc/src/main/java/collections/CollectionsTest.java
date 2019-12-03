package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(null);
        Collections.fill(list, 1);
        System.out.println(list);

        List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata"); // Immutable collection
        System.out.println(places);
        places.set(0, "Rome");
        System.out.println(places);
//        places.add("London"); // UnsupportedOperationException

        places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        places.add("London");
        System.out.println(places);
    }
}
