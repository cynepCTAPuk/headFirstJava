package beginning.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericExampleMethod<T> {
    public static <T> T getTheFirst(List<T> list) {
        return list.get(0);
    }
    public static <T> T getTheSecond(List<T> list) {
        return list.get(1);
    }

    public static void main(String[] args) {
        List<Integer> listOfInts = new ArrayList<>();
        listOfInts.add(0);
        listOfInts.add(1);
        Integer intValue1 = getTheFirst(listOfInts);
        Integer intValue2 = getTheSecond(listOfInts);
        System.out.println(intValue1 + " "+ intValue2);

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Java is the best!");
        listOfStrings.add("Ура!");
        String stringValue1 = getTheFirst(listOfStrings);
        String stringValue2 = getTheSecond(listOfStrings);
        System.out.println(stringValue1+" "+stringValue2);
    }
}
