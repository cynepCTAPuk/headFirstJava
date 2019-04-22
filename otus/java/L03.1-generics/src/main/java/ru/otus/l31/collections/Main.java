package ru.otus.l31.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tully.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class Main {
    private static final int MEASURE_COUNT = 1;
    private static final int min = 0;
    private static final int max = 9_999_999;

    public static void main(String... args) {
        Collection<Integer> arrayList = new ArrayList<>();
        fillCollection(arrayList);
//        Collections.shuffle((List<Integer>) arrayList);
//        calcTime(() -> Collections.sort((List<Integer>) arrayList);
        calcTime(() -> arrayList.contains(max));
        System.out.println(" - ArraySet");

        Collection<Integer> hashSet = new HashSet<>();
        fillCollection(hashSet);
//        Collections.shuffle((List<Integer>) hashSet);
        calcTime(() -> hashSet.contains(max));
        System.out.println(" - HashSet");

        Collection<Integer> linkedList = new LinkedList<>();
        fillCollection(linkedList);
//        Collections.shuffle((List<Integer>) linkedList);
        calcTime(() -> linkedList.contains(max));
        System.out.println(" - LinkedList");

/*
        Collection<Integer> linkedHashSet = new LinkedHashSet<>();
        fillCollection(linkedHashSet);
//        Collections.shuffle((List<Integer>) linkedHashSet);
        calcTime(() -> linkedHashSet.contains(max));
        System.out.println(" - LinkedHashSet");
*/

/*
        Collection<Integer> treeSet = new TreeSet<>();
        fillCollection(treeSet);
//        Collections.shuffle((List<Integer>) treeSet);
        calcTime(() -> treeSet.contains(max));
        System.out.println(" - TreeSet");
*/
    }

    private static void fillCollection(Collection<Integer> example) {
        for (int i = min; i < max + 1; i++) example.add(i);
    }

    private static void calcTime(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < MEASURE_COUNT; i++) runnable.run();
        long finishTime = System.nanoTime();
        long timeNs = (finishTime - startTime) / MEASURE_COUNT;
        System.out.printf("Time spent: %,14d ns ( %,5d ms)",
                timeNs, timeNs / 1_000_000);
    }
}
