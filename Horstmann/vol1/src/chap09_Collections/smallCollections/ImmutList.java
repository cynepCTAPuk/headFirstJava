package chap09_Collections.smallCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutList {
    public static void main(String[] args) {
        List<String> names1 = List.of("Lokesh", "Amit", "John");

        //Preserve the elements order
        System.out.println(names1);
//        Collections.sort(names1); //UnsupportedOperationException
//        names1.add("Brian"); //UnsupportedOperationException
        //java.lang.NullPointerException
//        List<String> names2 = List.of("Lokesh", "Amit", "John", null);

        List<String> names2 = new ArrayList<>(names1);
        names2.add("Mustafa");
        System.out.println(names2);
        Collections.rotate(names2, 1);
        System.out.println(names2);
        System.out.println(names2.subList(1,3));

        names2.clear();
        System.out.println(names2);
    }
}
