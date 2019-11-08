package p010;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibIterate {
    static final int SIZE = 4096;
    @Param({"1", "1024"})
    int backoff;
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
    public BigInteger seqSum() {
        return stream().limit(SIZE).reduce(BigInteger.ZERO, action);
    }

    @Benchmark
    public BigInteger parSum() {
        return stream().parallel().limit(SIZE).reduce(BigInteger.ZERO, action);
    }

    public static Stream<BigInteger> stream() {
        return Stream.iterate(
                new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                (BigInteger[] p) -> new BigInteger[]{p[1], p[0].add(p[1])})
                .map((BigInteger[] p) -> p[1]);
    }
}

