package collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        Map<Data, String> map = new WeakHashMap<>();
        Data data = new Data();
        map.put(data, "information");

        data = null;
        System.gc();

        for (int i = 0; i < 10_000; i++) {
            if (map.isEmpty()) {
                System.out.println("Empty! A fter " + i + " iteration");
                break;
            }
        }
    }
}

class Data {
}