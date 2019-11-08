package p010;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class n001Test {
    static final int SIZE = 4096;
    @Param({"1", "1024"})
    int backoff;
    static final BigInteger LIMIT = BigInteger.valueOf(4).multiply(BigInteger.TEN.pow(2048));
    Predicate<BigInteger> filterPredicate = b -> !b.testBit(0);
    Predicate<BigInteger> whilePredicate = b -> b.compareTo(LIMIT) < 0;
    BinaryOperator<BigInteger> action;

    @Setup
    public void setup() {
        int back = backoff;
        action = (x, y) -> {
            Blackhole.consumeCPU(back);
            return x.add(y);
        };
    }

    @Benchmark
    public BigInteger seqIterate() {
        Stream<BigInteger> s = FibIterate.stream().filter(filterPredicate);
        return TakeWhile.stream(s, whilePredicate).reduce(BigInteger.ZERO, action);
    }

    @Benchmark
    public BigInteger parIterate() {
        Stream<BigInteger> s = FibIterate.stream().filter(filterPredicate);
        return TakeWhile.stream(s, whilePredicate).parallel().reduce(BigInteger.ZERO, action);
    }

    @Benchmark
    public BigInteger seqIterator() {
        Stream<BigInteger> s = FibIterator.stream().filter(filterPredicate);
        return TakeWhile.stream(s, whilePredicate).reduce(BigInteger.ZERO, action);
    }

    @Benchmark
    public BigInteger parIterator() {
        Stream<BigInteger> s = FibIterator.stream().filter(filterPredicate);
        return TakeWhile.stream(s, whilePredicate).parallel().reduce(BigInteger.ZERO, action);
    }
    @Benchmark
    public BigInteger seqSum() {
        BigInteger first = BigInteger.ZERO;
        BigInteger second = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < SIZE; i++) {
            BigInteger s = second.add(first);
            first = second;
            second = s;
            sum = action.apply(sum, first);
        }
        return sum;
    }
}
