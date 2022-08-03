package shortPuzzles;

public class Foo1 {
    public static void main(String[] args) {
        System.out.println(foo());
    }

    public static int foo() {
        try {
            throw  new RuntimeException();
        } finally {
            return 42;
        }
    }
}
