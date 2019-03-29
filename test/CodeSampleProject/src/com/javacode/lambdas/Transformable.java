package com.javacode.lambdas;

@FunctionalInterface
interface Transformable<T> {
    T transorm(T t);
}
