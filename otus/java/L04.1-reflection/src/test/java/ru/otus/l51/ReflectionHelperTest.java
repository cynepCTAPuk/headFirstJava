package ru.otus.l51;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tully.
 */
public class ReflectionHelperTest {

    private TestClass testClass;

    @Before
    public void setUp() {
        testClass = ReflectionHelper.instantiate(TestClass.class);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void instantiate() {
        Assert.assertEquals(TestClass.DEFAULT_A, testClass.getA());
        Assert.assertEquals(TestClass.DEFAULT_S, testClass.getS());
        Assert.assertEquals(1, ReflectionHelper.instantiate(TestClass.class, 1).getA());
        Assert.assertEquals("A", ReflectionHelper.instantiate(TestClass.class, 1, "A").getS());
    }

    @Test
    public void getFieldValue() {
        Assert.assertEquals("A", ReflectionHelper.getFieldValue(new TestClass(1, "A"), "s"));
        Assert.assertEquals(1, ReflectionHelper.getFieldValue(new TestClass(1, "B"), "a"));
    }

    @Test
    public void setFieldValue() {
        testClass = new TestClass(1, "A");
        Assert.assertEquals("A", testClass.getS());
        ReflectionHelper.setFieldValue(testClass, "s", "B");
        Assert.assertEquals("B", testClass.getS());
    }

    @Test
    public void callMethod() {
        Assert.assertEquals("A", ReflectionHelper.callMethod(new TestClass(1, "A"), "getS"));

        testClass = new TestClass(1, "A");
        ReflectionHelper.callMethod(testClass, "setDefault");
        Assert.assertEquals("", testClass.getS());
    }

}
