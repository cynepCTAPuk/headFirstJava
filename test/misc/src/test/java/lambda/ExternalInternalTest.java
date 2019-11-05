package lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ExternalInternalTest {
    @Test
    public void testExternal() {
        StringBuilder sb = new StringBuilder();
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        for (String s : strings) sb.append(s);
        Assert.assertEquals("FooBarBaz", sb.toString());
    }

    @Test
    public void testInternal() {
        StringBuilder sb = new StringBuilder();
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
//        strings.stream().filter((s) -> s.startsWith("F")).forEach(sb::append);
        strings.parallelStream().filter((s) -> s.startsWith("F")).forEach(sb::append);
        Assert.assertEquals("Foo", sb.toString());

    }
}
