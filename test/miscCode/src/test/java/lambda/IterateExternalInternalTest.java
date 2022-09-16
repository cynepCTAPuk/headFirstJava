package lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IterateExternalInternalTest {
    @Test
    public void testExternal() {
        StringBuilder sb = new StringBuilder();
        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        for (String s : strings) sb.append(s);
//        String s = strings.stream().collect(Collectors.joining());
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
