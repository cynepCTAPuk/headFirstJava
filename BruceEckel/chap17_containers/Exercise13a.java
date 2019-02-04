package chap17_containers;
import util.*;
import java.util.*;
public class Exercise13a {
    static void printQtyWords(String file) {
        List<String> arrayList = new ArrayList<>(new TextFile(file, "\\W+"));
        Map<String, Integer> map = new TreeMap<>();
        for (String s : arrayList) map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
        System.out.println("Quantity words = " + map.size() + "\n" + map);
    }
    public static void main(String[] args) {
        String file = "chap17_containers/Exercise13a.java";
        printQtyWords(file);
    }
}
