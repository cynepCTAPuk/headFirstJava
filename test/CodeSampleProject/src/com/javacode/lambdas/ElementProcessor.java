package com.javacode.lambdas;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
    double process(T element);
}
