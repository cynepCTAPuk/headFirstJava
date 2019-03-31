package ru.otus.l32;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author sergey
 * created on 23.07.18.
 */
@State(value = Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHexample {
    private static final int ARRAY_SIZE_MAX = 1_000_000;
    private static int ARRAY_SIZE_INIT = 10;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHexample.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

    private MyArrayInt myArr;
    private List<Integer> arrayList;

    @Setup
    public void setup() throws Exception {
        myArr = new MyArrayInt(ARRAY_SIZE_INIT);
        arrayList = new ArrayList<>(ARRAY_SIZE_INIT);
    }

    @Benchmark
    public long myArrayIntTest() throws Exception {
        for (int idx = 0; idx < ARRAY_SIZE_MAX; idx++) {
            myArr.setValue(idx, idx);
        }

        long summ = 0;
        for (int idx = 0; idx < ARRAY_SIZE_MAX; idx++) {
            summ += myArr.getValue(idx);
        }
        return summ;
    }

    @Benchmark
    public long ArrayListTest() {
        for (int idx = 0; idx < ARRAY_SIZE_MAX; idx++) {
            arrayList.add(idx, idx);
        }

        long summ = 0;
        for (int idx = 0; idx < ARRAY_SIZE_MAX; idx++) {
            summ += arrayList.get(idx);
        }
        return summ;
    }
}
