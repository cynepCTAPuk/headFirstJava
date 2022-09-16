package patterns.strategy.task3310.tests;

import org.junit.Assert;
import org.junit.Test;
import patterns.strategy.task3310.Shortener;
import patterns.strategy.task3310.strategy.*;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String string1 = "javaRush";
        String string2 = "welcome";
        String string3 = "javaRush";

        Long l1 = shortener.getId(string1);
        Long l2 = shortener.getId(string2);
        Long l3 = shortener.getId(string3);
        Assert.assertNotEquals(l2, l1);
        Assert.assertNotEquals(l2, l3);
        Assert.assertEquals(l1, l3);

        String getString1 = shortener.getString(l1);
        String getString2 = shortener.getString(l2);
        String getString3 = shortener.getString(l3);
        Assert.assertEquals(getString1, string1);
        Assert.assertEquals(getString2, string2);
        Assert.assertEquals(getString3, string3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() {
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }
}
