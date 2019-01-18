package chap07_reusing.ex07;

public class Exercise7 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class A {
    A(int i) {
        System.out.println("A");
    }
}

class B {
    B() {
        System.out.println("B");
    }
}

class C extends A {
    B b = new B();

    C() {
        super(1);
        System.out.println("C");
    }
}

