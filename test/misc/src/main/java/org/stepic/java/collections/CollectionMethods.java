package org.stepic.java.collections;

import java.util.*;

public class CollectionMethods {
    public static void main(String[] args) {
/*
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = alphabet.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) list.add(c);

        System.out.println(list);
        list.subList(1, 3).clear();
        System.out.println(list);
*/

        Collection<?> collection = new LinkedList<>();
        Object object = new Object();

//        collection.addAll(Arrays.asList(object));
//        collection.removeAll(object);
//        collection.add(object);

        collection.contains(object);
        collection.toArray();

        collection.size();
        collection.clear();

        Iterator iterator = collection.iterator();
/*
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2));
        System.out.println(symmetricDifference(set1, set2));
*/
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> setUnique1 = new HashSet(set1);
        setUnique1.addAll(set2);
        setUnique1.removeAll(set2);

        Set<T> setUnique2 = new HashSet(set1);
        setUnique2.addAll(set2);
        setUnique2.removeAll(set1);

        setUnique1.addAll(setUnique2);

        return setUnique1;
    }
}
