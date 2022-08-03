package shortPuzzles;

public class Foo {
    public static void main(String[] args) {
        System.out.println(foo());
    }

    public static int foo() {
        try {
            return 0;
        } finally {
            return 42;
        }
    }
}
