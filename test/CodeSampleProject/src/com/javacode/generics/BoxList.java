package com.javacode.generics;

import java.util.*;

public interface BoxList<E, T> extends List<E> {
    T calcSum(E elem1, T elem2);
}
