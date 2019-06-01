package org.sample;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Fork(1)
@Warmup(iterations = 10)
@Measurement(iterations = 5)
//@BenchmarkMode(TimeUnit.MICROSECONDS)
public class MyBenchmark {
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        public static final int SEED = 42;
        public static final int ARRAY_LENGTH = 1_000_000;
        volatile Person[] array;

        @Setup
        public void initState() {
            Random random = new Random(SEED);
            array = new Person[ARRAY_LENGTH];
            for (int i = 0; i < array.length; i++) {
                Person person = new Person();
                person.setName("N" + random.nextInt());
                person.setAge(random.nextInt(50));
                person.setChildern(random.nextInt(100));
                array[i] = person;
            }
        }
    }

    @Benchmark
    public static List<Person> streamApi(BenchmarkState state) {
        List<Person> result = Arrays
                .stream(state.array)
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getChildern() > 50)
                .collect(Collectors.toList());
        return result;
    }

    @Benchmark
    public static List<Person> streamApiOneFilter(BenchmarkState state) {
        List<Person> result = Arrays
                .stream(state.array)
                .filter(person -> (person.getAge() > 18) & (person.getChildern() > 50))
                .collect(Collectors.toList());
        return result;
    }

    @Benchmark
    public static List<Person> guava(BenchmarkState state) {
        List<Person> list = Arrays.asList(state.array);
        Iterable result = Iterables.filter(
                list, person -> (person.getAge() > 18) & (person.getChildern() > 50));
        return Lists.newArrayList(result);
    }
}
