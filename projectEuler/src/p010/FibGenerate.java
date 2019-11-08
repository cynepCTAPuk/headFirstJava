package p010;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibGenerate {
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

    public static Stream<BigInteger> stream() {
        return Stream.generate(
                new Supplier<BigInteger>() {
                    private BigInteger first = BigInteger.ZERO;
                    private BigInteger second = BigInteger.ONE;

                    @Override
                    public BigInteger get() {
                        BigInteger s = second.add(first);
                        first = second;
                        second = s;
                        return first;
                    }
                }
        );
    }
}
