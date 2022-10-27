package y22;

import java.util.HashMap;
import java.util.Map;

public class Q220523_2 extends Q220523 {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap() {
            {
                put("Robert", 30);
                put("John", 22);
                put("Alex", 29);
            }
        };
        System.out.println(ages);
    }
}

