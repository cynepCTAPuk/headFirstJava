package org.stepic.java.functional;

import java.util.Objects;
import java.util.function.*;

public class Demo {
    private int counter;
    private static final int bonus = 10;
    IntUnaryOperator sq = x -> x * x;
    IntSupplier sequence = () -> counter++;
    IntUnaryOperator bonusAdder = x -> x + bonus;
    Consumer consumer = x -> System.out.println(x + "" + x);

    IntPredicate isOdd = x -> x % 2 != 0;
    IntPredicate isEven = isOdd.negate();

    DoubleUnaryOperator square = x -> x * x;
    DoubleUnaryOperator sin = Math::sin;
    DoubleUnaryOperator func1 = sin.andThen(square);
    DoubleUnaryOperator func2 = sin.compose(square);


    public static void main(String[] args) {
/*
        Demo demo = new Demo();
        System.out.println(demo.sq.applyAsInt(10));
        System.out.println(demo.sequence.getAsInt());
        System.out.println(demo.sequence.getAsInt());
        System.out.println(demo.sequence.getAsInt());
        System.out.println(demo.bonusAdder.applyAsInt(33));

        demo.consumer.accept("ha");

        System.out.println(demo.func1.applyAsDouble(Math.PI / 2));
        System.out.println(demo.func2.applyAsDouble(10));
*/

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;

        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply("Test"));
        System.out.println(safeStringLength.apply(null));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }
}
