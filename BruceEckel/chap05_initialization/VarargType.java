package chap05_initialization;

//: initialization/VarargType.java
public class VarargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    public static void main(String[] args) {
        f('a', 'b');
        f();
        g(1, 2);
        g();
        System.out.println("int[]: " + new int[0].getClass());
    }
} /* Output:
class [Ljava.lang.Character; length 1
class [Ljava.lang.Character; length 0
class [I length 1
class [I length 0
int[]: class [I
*///:~