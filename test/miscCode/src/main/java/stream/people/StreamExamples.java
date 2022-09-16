package stream.people;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        final String empty = "empty";
        List<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        long filterCount = collection.stream().filter("a1"::equals).count();
        System.out.println("filter-count: " + filterCount);
        String findFirst = collection.stream().findFirst().orElse(empty);
        System.out.println("findFirst-orElse: " + findFirst);
        long x = 2L;
        long n = collection.size() - x;
        String skipFindFirst = collection.stream().parallel().skip(n).findFirst().orElse(empty);
        System.out.println("parallel-skip " + n + " findFirst-orElse : " + skipFindFirst);
        String skipFindAny = collection.stream().sequential().skip(n).findAny().orElse(empty);
        System.out.println("sequential-skip " + n + " findAny-orElse : " + skipFindAny);
        String filterFindFirst = collection.stream().filter("a3"::equals).findFirst().orElse(empty);
        System.out.println("filter-findFirst-orElse: " + filterFindFirst);
        String skipLimitToArray = Arrays.toString(collection.stream().skip(1).limit(2).toArray());
        System.out.println("skip-limit-toArray:   " + skipLimitToArray);
        List<String> filterCollectToList = collection.stream().filter(s -> s.contains("1")).collect(Collectors.toList());
        System.out.println("filter-collectToList: "+filterCollectToList);
        collection.stream().peek(a -> System.out.print(a + "x ")).collect(Collectors.toList());
        System.out.println();
        System.out.println(collection);

        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Петя", 23, Sex.MAN),
                new People("Наталья", 17, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));

        List<People> collect1 = peoples.stream().filter(p -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN).collect(Collectors.toList());
        System.out.println(collect1);

        double asDouble = peoples.stream()
                .filter((p) -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
//        System.out.println(asDouble);

        long count1 = peoples.stream()
                .filter((p) -> p.getAge() >= 18)
                .filter((p) -> (p.getSex() == Sex.WOMEN && p.getAge() < 55)
                        || (p.getSex() == Sex.MAN && p.getAge() < 60))
                .count();
//        System.out.println(count1);

        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");

        Collection<String> nonOrdered = new HashSet<>(ordered);
        List<String> collect2 = nonOrdered.stream()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(collect2); // порядок не гарантируется
        List<String> collect3 = ordered.stream()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(collect3);  // порядок гарантируется

//        System.out.println(collection.stream().anyMatch("a1"::equals));
//        System.out.println(collection.stream().anyMatch("a8"::equals));
//        System.out.println(collection.stream().allMatch((s) -> s.contains("1")));
//        System.out.println(collection.stream().noneMatch("a7"::equals));

        Collection<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");

        List<String> collect4 = collection1.stream()
                .map((s) -> s + "_1")
                .collect(Collectors.toList());
//        System.out.println(collect4);

        String x3 = Arrays.toString(collection1.stream()
                .mapToInt((s) -> Integer.parseInt(s.substring(1)))
                .toArray());
//        System.out.println(x3);

        String x4 = Arrays.toString(collection2.stream()
                .flatMap((p) -> Arrays.asList(p.split(",")).stream())
                .toArray(String[]::new));
//        System.out.println(x4);

        int sum = collection2.stream()
                .flatMapToInt((p) -> Arrays.asList(p.split(",")).stream().mapToInt(Integer::parseInt))
                .sum();
//        System.out.println(sum);

        collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        collection.stream()
                .sorted()
                .collect(Collectors.toList());
        collection.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        collection.stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        collection.stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .distinct()
                .collect(Collectors.toList());
        peoples.stream()
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList());
        List<People> collect5 = peoples.stream()
                .sorted((o1, o2) -> o1.getSex() != o2.getSex()
                        ? o1.getSex().compareTo(o2.getSex())
                        : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
//        System.out.println(collect5);

        collection.stream().max(String::compareTo).get();
        collection.stream().min(String::compareTo).get();
        peoples.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        peoples.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();

        Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 2, 3);
        integers = Arrays.asList(); // demonstrate orElse()

        Integer x5 = integers.stream()
                .reduce(Integer::sum).orElse(0);
//        System.out.println(x5);

        Integer x6 = integers.stream()
                .filter(o -> o % 2 != 0)
                .reduce(Integer::sum).orElse(0);
//        System.out.println(x6);

        Integer x7 = integers.stream()
                .reduce(Integer::max).orElse(-1);
//        System.out.println(x7);
    }
}
