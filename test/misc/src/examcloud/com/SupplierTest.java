package examcloud.com;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Boolean> s = () -> {
            Random generator = new Random();
            int n = generator.nextInt(1);
            return n % 2 == 0;
        };
//        System.out.println(s.getAsBoolean());
        System.out.println(s.get().booleanValue());
    }
}
