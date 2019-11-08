package p010;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.function.BinaryOperator;

public class FibOldSchool {
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
