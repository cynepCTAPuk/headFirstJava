package org.stepic.java.optional;

import java.util.Optional;

public class Example<X> {
    public void someMethod(Object obj) {
        X x1 = (X) obj;
        Optional<X> o = Optional.empty();
//        boolean b1 = obj instanceof Optional<X>;
//        boolean b2 = obj instanceof X;
//        X[] array = new X[0];
//        X x2 = new Example<X>();

    }

    public static void main(String[] args) {
        new Example<String>().someMethod(new Object());
    }
}
