package patterns.strategy.task3310.tests;

import org.junit.Assert;
import org.junit.Test;
import patterns.strategy.task3310.Helper;
import patterns.strategy.task3310.Shortener;
import patterns.strategy.task3310.strategy.HashBiMapStorageStrategy;
import patterns.strategy.task3310.strategy.HashMapStorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Long start = new Date().getTime();
        for (String string : strings) ids.add(shortener.getId(string));
        Long end = new Date().getTime();
        return end - start;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Long start = new Date().getTime();
        for (Long key : ids) strings.add(shortener.getString(key));
        Long end = new Date().getTime();
        return end - start;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10_000; i++) origStrings.add(Helper.generateRandomString());
        Set<Long> shorteners = new HashSet<>();

        Long time1 = getTimeToGetIds(shortener1, origStrings, shorteners);
        Long time2 = getTimeToGetIds(shortener2, origStrings, shorteners);
        Assert.assertTrue(time1 > time2);

        time1 = getTimeToGetStrings(shortener1, shorteners, origStrings);
        time2 = getTimeToGetStrings(shortener2, shorteners, origStrings);
        Assert.assertEquals(time1, time2, 30);
    }
}
