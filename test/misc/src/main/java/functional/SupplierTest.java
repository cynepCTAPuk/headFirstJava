package functional;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;
        List<UUID> uuids = Stream.generate(randomUUIDSupplier).limit(3).collect(Collectors.toList());
        System.out.println(uuids);

        Supplier<Integer> supplier = () -> RandomUtils.nextInt(0, 101);
        IntSummaryStatistics s = Stream.generate(supplier).parallel().limit(1_000_000)
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(s);
        Object[] array = Stream.generate(supplier).limit(20).toArray();
        System.out.println(Arrays.toString(array) + " \tArray");
        List<Integer> list = Stream.generate(supplier).limit(20).collect(Collectors.toList());
        System.out.println(list + " \tArrayList");

        Integer reduce = list.stream().limit(2).reduce(0, Integer::sum);
        System.out.println(reduce + " \t.limit(2).reduce(0, Integer::sum)");
        Integer max = list.stream().reduce(0, Integer::max);
        System.out.println(max + " \t.reduce(0, Integer::max)");

        boolean b = list.stream().anyMatch(x -> x == 99);
        System.out.println(b + " \t.anyMatch(x -> x == 99)");

        System.out.println(Integer.sum(1, 2) + " Integer.sum");
    }
}
