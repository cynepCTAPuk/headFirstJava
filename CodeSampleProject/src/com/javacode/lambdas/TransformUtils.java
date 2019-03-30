package com.javacode.lambdas;

public class TransformUtils<T> {
    T transform(T t, Transformable<T> function) {
        return function.transorm(t);
    }

    static String exclaim(String s) {
        return s.toUpperCase() + "!!!!";
    }
}
