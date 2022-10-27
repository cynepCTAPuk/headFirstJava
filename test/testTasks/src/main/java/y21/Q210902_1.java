package y21;

import java.util.EnumMap;
import java.util.Map;

public class Q210902_1 {
    static Integer value;

    public static void main(String... args) {
        Map<Types, Integer> m = new EnumMap<>(Types.class);
        m.put(Types.A, value);
        m.put(Types.B, 2);
        m.put(Types.C, value);
        System.out.println(m);
    }
}
enum Types{A, B, C}


