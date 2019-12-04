package oop;

interface A {
    int methodB(int i);
}

class B implements A {
    @Override
    public int methodB(int i) {
        return i = +i * i;
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        A b = new B();
        System.out.println(b.methodB(2));
    }
}


