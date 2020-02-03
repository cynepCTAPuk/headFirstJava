package patterns.strategy.task3310;

import patterns.strategy.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        testStrategy(new FileStorageStrategy(), 10);
        testStrategy(new OurHashBiMapStorageStrategy(),10_000);
        testStrategy(new HashBiMapStorageStrategy(),10_000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10_000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String string : strings) set.add(shortener.getId(string));
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key : keys) set.add(shortener.getString(key));
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) set.add(Helper.generateRandomString());

        Shortener shortener = new Shortener(strategy);

        Long start = new Date().getTime();
        Set<Long> setKeys = getIds(shortener, set);
        Long end = new Date().getTime();
        System.out.println(end - start);

        start = new Date().getTime();
        Set<String> setStrings = getStrings(shortener, setKeys);
        end = new Date().getTime();
        System.out.println(end - start);

        if (set.equals(setStrings)) System.out.println("Тест пройден.");
        else System.out.println("Тест не пройден.");
    }

}
