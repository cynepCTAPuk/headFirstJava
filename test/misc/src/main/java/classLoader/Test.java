package classLoader;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
//        System.out.println("System.getClass().getClassLoader() : " + System.class.getClassLoader());
//        Arrays.stream(System.class.getInterfaces()).forEach(System.out::println);
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(Long.class.getFields()).forEach(x -> System.out.println(i.incrementAndGet() + ":" + x));
    }
}
