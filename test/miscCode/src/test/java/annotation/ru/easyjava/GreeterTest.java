package annotation.ru.easyjava;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class GreeterTest {
    @Test
    public void testGreen() {
        Greeter testedObject = new Greeter();
        Assert.assertThat(testedObject.greet("TEST"), is("Hello, TEST"));
        Assert.assertEquals("Hello, TEST",testedObject.greet("TEST"));
    }


}