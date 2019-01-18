package chap07_reusing.ex08;

public class Exercise8 {
    public static void main(String[] args) {
        B b = new B(1);
    }
}

class A {
    A() {
        System.out.println("A");
    }
}

class B extends A {
    B() {
        super();
        System.out.println("B");
    }

    B(int i) {
        super();
        System.out.println("B i");
    }

}


