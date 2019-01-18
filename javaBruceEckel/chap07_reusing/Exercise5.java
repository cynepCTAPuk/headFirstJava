package chap07_reusing;

public class Exercise5 {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c);
    }
}

class A {
    A() { System.out.println("A"); }
}

class B {
    B() { System.out.println("B"); }
}

class C extends A {
    B b = new B();
    C() { System.out.println("C"); }
}

