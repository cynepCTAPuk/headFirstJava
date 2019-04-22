package ru.otus.l31.collections;

import java.util.*;

/**
 * Created by tully.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class Main {
    private static final int MEASURE_COUNT = 1;
    private static final int min = 0;
    private static final int max = 3_999_999;

    public static void main(String... args) {
/*
        Collection<Integer> arrayList = new ArrayList<>();
        fillCollection(arrayList);
//        Collections.shuffle((List<Integer>) arrayList);
//        calcTime(() -> Collections.sort((List<Integer>) arrayList);
        calcTime(() -> arrayList.contains(max));
        System.out.println(" - ArraySet");
*/

        System.out.printf("Integer.MAX_VALUE = %,d\n", Integer.MAX_VALUE);
        System.out.printf("Integer.MIN_VALUE = %,d\n", Integer.MIN_VALUE);

/*
        Collection<Integer> hashSet = new HashSet<>();
        fillCollection(hashSet);
        calcTime(() -> hashSet.contains(max));
        System.out.println(" - HashSet");

        Collection<Integer> linkedList = new LinkedList<>();
        fillCollection(linkedList);
        calcTime(() -> linkedList.contains(max));
        System.out.println(" - LinkedList");

        Collection<Integer> linkedHashSet = new LinkedHashSet<>();
        fillCollection(linkedHashSet);
        calcTime(() -> linkedHashSet.contains(max));
        System.out.println(" - LinkedHashSet");

        Collection<Integer> treeSet = new TreeSet<>();
        fillCollection(treeSet);
        calcTime(() -> treeSet.contains(max));
        System.out.println(" - TreeSet");
*/
    }

    private static void fillCollection(Collection<Integer> collection) {
        for (int i = min; i < max + 1; i++) collection.add(i);
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
