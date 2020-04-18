package org.stepic.java.generic;

import nonapi.io.github.classgraph.json.JSONUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ref<? super Number> ref = new Ref();
        ref.setValue(1.0);
        System.out.println(ref);
//        ref.setValue(ref.getValue());

        HasArrayList<?> h = new HasArrayList<>(new ArrayList<>());
        ArrayList list = h.getList();
    }

}

class HasList<T extends List> {
    protected final T list;

    public HasList(T list) {
        this.list = list;
    }

    public T getList() {
        return list;
    }
}

class HasArrayList<T extends ArrayList> extends HasList<T> {
    public HasArrayList(T list) {
        super(list);
    }
}

class Ref<T> {
    private T value = null;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "value=" + value +
                '}';
    }
}
