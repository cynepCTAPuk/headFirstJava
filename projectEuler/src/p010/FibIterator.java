package p010;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FibIterator {
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
        Iterator<BigInteger> bit = new FibonacciIterator();
        Spliterator<BigInteger> bsplit = Spliterators.spliteratorUnknownSize(bit,
                Spliterator.ORDERED | Spliterator.SORTED | Spliterator.NONNULL|Spliterator.IMMUTABLE);
        return StreamSupport.stream(bsplit, false);
    }

    static class FibonacciIterator implements Iterator<BigInteger> {
        private BigInteger first = BigInteger.ZERO;
        private BigInteger second = BigInteger.ONE;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            BigInteger s = second.add(first);
            first = second;
            second = s;
            return first;
        }
    }
}

