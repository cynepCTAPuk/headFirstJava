package book.chap10;

class StaticSuper {
    static {
        System.out.println("super static block");               // #1 -
    }

    StaticSuper() {
        System.out.println("super constructor");                // #4 ----
    }
}

public class StaticTests extends StaticSuper{
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);             // #2 --
    }

    StaticTests() {
        System.out.println("constructor");                      // #5 -----
    }

    public static void main(String[] args) {
        System.out.println("in main");                          // #3 ---
        StaticTests st = new StaticTests();
    }
}
