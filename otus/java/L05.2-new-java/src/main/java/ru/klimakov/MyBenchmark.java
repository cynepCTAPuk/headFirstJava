package ru.klimakov;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyBenchmark {
    public static class BenchmarkState {
        public static final int SEED = 42;
        public static final int ARRAY_LENGTH = 1_000;
        volatile Person[] array;

        public void initState() {
            Random random = new Random(SEED);
            array = new Person[ARRAY_LENGTH];
            for (int i = 0; i < array.length; i++) {
                Person person = new Person();
                person.setName("N" + random.nextInt());
                person.setAge(random.nextInt(200));
                person.setChildern(random.nextInt(100));
                array[i] = person;
            }
        }
    }

    public List<Person> streamApi(BenchmarkState state) {
        List<Person> result = Arrays
                .stream(state.array)
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getChildern() > 50)
                .collect(Collectors.toList());
        return result;
    }

    public List<Person> guava(BenchmarkState state) {
        List<Person> list = Arrays.asList(state.array);
        Iterable result = Iterables.filter(list,
                person -> (person.getAge() > 18) || (person.getChildern() > 50));
        return Lists.newArrayList(result);
    }
}
