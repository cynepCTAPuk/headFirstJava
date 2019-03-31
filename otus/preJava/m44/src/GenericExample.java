import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static <T> T getTheFirst(List<T> list){
        return list.get(0);
    }
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);

        Integer intValue = getTheFirst(listOfIntegers);
        System.out.println(intValue);

        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Java is the best!");

        String stringValue = getTheFirst(listOfStrings);
        System.out.println(stringValue);
    }
}