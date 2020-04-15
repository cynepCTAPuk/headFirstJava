package org.stepic.java.optional;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<?> optional = Optional.of(1);
        System.out.println(optional.get());
//        System.out.println(optional.orElse(2));

        Example<CharSequence> cs;
        Example<?> q;
        Example e;
        Example<Object> obj;
        Example<Seasons> s;

    }
}

enum Seasons {
    SUMMER, AUTUMN, WINTER, SPRING
}