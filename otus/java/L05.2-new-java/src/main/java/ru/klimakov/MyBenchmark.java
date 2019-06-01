package ru.klimakov;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyBenchmark {
    public static class BenchmarkState {
        public static final int SEED = 42;
        public static final int ARRAY_LENGTH = 1_000_000;
        volatile Person[] array;

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

    public static List<Person> streamApi(BenchmarkState state) {
        List<Person> result = Arrays
                .stream(state.array)
                .parallel()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getChildern() > 50)
                .collect(Collectors.toList());
        return result;
    }

    public static List<Person> streamApiOneFilter(BenchmarkState state) {
        List<Person> result = Arrays
                .stream(state.array)
                .parallel()
                .filter(person -> (person.getAge() > 18) & (person.getChildern()>50))
                .collect(Collectors.toList());
        return result;
    }

    public static List<Person> guava(BenchmarkState state) {
        List<Person> list = Arrays.asList(state.array);
        Iterable result = Iterables.filter(
                list, person -> (person.getAge() > 18) & (person.getChildern() > 50));
        return Lists.newArrayList(result);
    }

    public static void main(String[] args) {
        BenchmarkState benchmarkState = new BenchmarkState();
        benchmarkState.initState();

        long t0 = System.currentTimeMillis();
        List<Person> listStreamApi = streamApi(benchmarkState);
        long t1 = System.currentTimeMillis();
        System.out.printf("listStreamApi          = %,d\n",t1 - t0);

        long t2 = System.currentTimeMillis();
        List<Person> listStreamApiOneFilter = streamApiOneFilter(benchmarkState);
        long t3 = System.currentTimeMillis();
        System.out.printf("listStreamApiOneFilter = %,d\n",t3 - t2);

        long t4 = System.currentTimeMillis();
        List<Person> listGuava = guava(benchmarkState);
        long t5 = System.currentTimeMillis();
        System.out.printf("listGuava              = %,d\n",t5 - t4);
    }
}
