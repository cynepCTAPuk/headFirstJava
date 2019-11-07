package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        List<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Петя", 23, Sex.MAN),
                new People("Наталья", 17, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN));

        System.out.println(
                collection.stream()
                        .filter("a1"::equals)
                        .count());
        System.out.println(
                collection.stream()
                        .findFirst().orElse("0"));
        System.out.println(
                collection.stream()
                        .skip(collection.size() - 1)
                        .findAny().orElse("empty"));
        System.out.println(
                collection.stream()
                        .filter("a3"::equals)
                        .findFirst()
                        .get());
        System.out.println(
                collection.stream()
                        .skip(2)
                        .findFirst()
                        .get());
        System.out.println(Arrays.toString(
                collection.stream()
                        .skip(1)
                        .limit(2)
                        .toArray()));
        System.out.println(
                collection.stream()
                        .filter((s) -> s.contains("1"))
                        .collect(Collectors.toList()));

        System.out.println(
                peoples.stream()
                        .filter((p) -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN)
                        .collect(Collectors.toList()));
        System.out.println(
                peoples.stream()
                        .filter((p) -> p.getSex() == Sex.MAN)
                        .mapToInt(People::getAge)
                        .average()
                        .getAsDouble());
        System.out.println(
                peoples.stream()
                        .filter((p) -> p.getAge() >= 18)
                        .filter((p) -> (p.getSex() == Sex.WOMEN && p.getAge() < 55)
                                || (p.getSex() == Sex.MAN && p.getAge() < 60))
                        .count());

        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<String>(ordered);
        System.out.println(
                nonOrdered.stream()
                        .distinct()
                        .collect(Collectors.toList())); // порядок не гарантируется
        System.out.println(
                ordered.stream()
                        .distinct()
                        .collect(Collectors.toList()));  // порядок гарантируется

        System.out.println(collection.stream().anyMatch("a1"::equals));
        System.out.println(collection.stream().anyMatch("a8"::equals));
        System.out.println(collection.stream().allMatch((s) -> s.contains("1")));
        System.out.println(collection.stream().noneMatch("a7"::equals));

        Collection<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");
        System.out.println(
                collection1.stream()
                        .map((s) -> s + "_1")
                        .collect(Collectors.toList()));
        System.out.println(Arrays.toString(
                collection1.stream()
                        .mapToInt((s) -> Integer.parseInt(s.substring(1)))
                        .toArray()));
        System.out.println(Arrays.toString(
                collection2.stream()
                        .flatMap((p) -> Arrays.asList(p.split(",")).stream())
                        .toArray(String[]::new)));
        System.out.println(
                collection2.stream()
                        .flatMapToInt((p) -> Arrays.asList(p.split(",")).stream().mapToInt(Integer::parseInt))
                        .sum());

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
        System.out.println(
                peoples.stream()
                        .sorted((o1, o2) -> o1.getSex() != o2.getSex()
                                ? o1.getSex().compareTo(o2.getSex())
                                : o1.getAge().compareTo(o2.getAge()))
                        .collect(Collectors.toList()));

        collection.stream().max(String::compareTo).get();
        collection.stream().min(String::compareTo).get();
        peoples.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        peoples.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();

        Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);
        System.out.println(
                integers.stream()
                        .reduce(Integer::sum).orElse(0));
        System.out.println(
                integers.stream()
                        .filter(o -> o % 2 != 0)
                        .reduce(Integer::sum).orElse(0));
        System.out.println(
                integers.stream()
                        .reduce(Integer::max).orElse(-1));
    }
}
