package aaa;

public class Q210811_1 {
    public static void main(String... args) {
        A alpha = new B();
    }
}

class A {
    A() {
        System.out.print("A");
        a();
    }

    void a() {
        System.out.print("a");
    }
}

class B extends A {
    B() {
        System.out.print("B");
        a();
    }

    @Override
    void a() {
        System.out.print("b");
    }
}