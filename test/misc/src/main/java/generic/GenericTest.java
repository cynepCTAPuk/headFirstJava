package generic;

import java.util.List;

public abstract class GenericTest {
    abstract T add(T a, T b); //сложить

    abstract T sub(T a, T b); //отнять

    abstract T mul(T a, T b); //умножить

    abstract T div(T a, T b); //делить

    private class T {
    }

    public void printState(List<? extends MyClass> list) {
        for (MyClass myClass : list) {
            System.out.println(myClass.getState()); // super тут не работает
        }
    }

    public void addSomething(List<? super MyClass> list) {
        list.add(new MyClass()); // меняем extends на super
    }

    private class MyClass {
        public boolean getState() {
            return false;
        }
    }
}
