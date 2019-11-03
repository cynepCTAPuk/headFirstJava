import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

public class Tests {
    @Test
    public void threadLocalLegacy() {
        final AtomicInteger counter = new AtomicInteger(1);
        ThreadLocal<Integer> t1Number = new ThreadLocal<>() {
            @Override
            protected Integer initialValue() {
                return counter.incrementAndGet();
            }
        };
        Assert.assertEquals(t1Number.get(), (Integer) 2);
        Assert.assertEquals(t1Number.get(), (Integer) 2);
    }

    @Test
    public void threadLocalLambda() {
        AtomicInteger counter = new AtomicInteger(0);
//        ThreadLocal<Integer> t1Number = new ThreadLocal<>(() -> counter.incrementAndGet());
//        Assert.assertEquals(t1Number.get(), (Integer) 1);
//        Assert.assertEquals(t1Number.get(), (Integer) 1);
    }

    @Test
    public void threadLocalMRef() {
        AtomicInteger counter = new AtomicInteger(0);
        Supplier<Integer> factory = counter::incrementAndGet;
//        ThreadLocal<Integer> t1Number = new ThreadLocal<>(factory);
//        Assert.assertEquals(t1Number.get(), (Integer) 1);
//        Assert.assertEquals(t1Number.get(), (Integer) 1);
    }

    @Test
    public void testParseInt() {
        Function<String, Integer> f = Integer::parseInt;
        Function<String, Integer> f1 = s -> Integer.parseInt(s, 2);
        System.out.println(f1.apply("111"));
        System.out.println(Integer.parseInt("111", 2));
        Assert.assertEquals(Integer.valueOf(0), f.apply("0"));
    }

    @Test
    public void testMethodRefStatic() {
        Comparator<Integer> cmp = Integer::compare;

        Assert.assertEquals(0, cmp.compare(0, 0));
        Assert.assertEquals(-1, cmp.compare(-100, 100));
        Assert.assertEquals(1, cmp.compare(100, -100));

//        Comparator<String> cmp1 = (cs1, cs2) -> cs1.compareTo(cs2);
        Comparator<String> cmp1 = String::compareTo;

        Assert.assertEquals(0, cmp1.compare("a", "a"));
        Assert.assertEquals(-1, cmp1.compare("a", "b"));
        Assert.assertEquals(1, cmp1.compare("b", "a"));
    }

    private IntUnaryOperator fib =
            (n) -> (n < 2) ? n : (this.fib.applyAsInt(n - 1) + this.fib.applyAsInt(n - 2));

    @Test
    public void testFib() {
        for (int i = 1; i < 12; i++) System.out.print(fib.applyAsInt(i) + " ");

        Assert.assertEquals(55, fib.applyAsInt(10));
    }

    private Predicate<String> makeCaseUnsensitiveMatcher(String pattern) {
        return s -> pattern.equalsIgnoreCase(s);
    }

    @Test
    public void testLambda1() {
        Assert.assertTrue(makeCaseUnsensitiveMatcher("true").test("TruE"));
        Assert.assertTrue(makeCaseUnsensitiveMatcher("false").test("FalsE"));
    }
}
