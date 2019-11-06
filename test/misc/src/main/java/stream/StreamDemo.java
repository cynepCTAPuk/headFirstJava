package stream;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        AtomicInteger aint = new AtomicInteger(0);
        List<Integer> list = Stream
//                .generate(aint::getAndIncrement)
                .iterate(0, i -> i + 1)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
