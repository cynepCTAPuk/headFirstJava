package chap03_operators;

//: operators/PassObject.java
// Passing objects to methods may not be
// what you’re used to.
class Letter {
    char c;
}

public class PassObject {
    static void f(Letter y, char ch) {
        y.c = ch;
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x,'y');
        System.out.println("2: x.c: " + x.c);
    }
} /* Output:
1: x.c: a
2: x.c: z
*///:~