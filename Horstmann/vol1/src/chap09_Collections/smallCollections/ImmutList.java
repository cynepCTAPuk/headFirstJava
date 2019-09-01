package chap09_Collections.smallCollections;

import java.util.List;

public class ImmutList {
    public static void main(String[] args) {
        List<String> names = List.of("Lokesh", "Amit", "John");

        //Preserve the elements order
        System.out.println(names);
//        Collections.sort(names); //UnsupportedOperationException
//        names.add("Brian"); //UnsupportedOperationException
        //java.lang.NullPointerException
//        List<String> names2 = List.of("Lokesh", "Amit", "John", null);

    }
}
