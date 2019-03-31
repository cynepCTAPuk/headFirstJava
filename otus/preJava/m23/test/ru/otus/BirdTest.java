package ru.otus;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.otus.good.Bird;
import ru.otus.good.Crow;

public class BirdTest {
    static int a = 0;

    @Before
    public void before() {
        a++;
        System.out.println("- Test " + a + " - запущен");
    }

    @Test
    public void nameTest() {
        System.out.println("nameTest");
        Bird bird = new Crow("Mag");
        Assert.assertEquals("Wrong name", "Mag", bird.getName());
    }

    @Test
    public void toStringTest() {
        System.out.println("toStringTest");
        String name = "Mag";
        Bird bird = new Crow(name);
//        Assert.assertNotNull(bird);
        String result = bird.toString();
        Assert.assertTrue(result.contains("Mag"));
    }

    @Test(expected = RuntimeException.class)
    public void wrongNameTest() {
        System.out.println("wrongNameTest");
        Bird bird = new Crow("");
    }

    @After
    public void after() {
        System.out.println("- Test " + a + " - завершён");
    }
}
