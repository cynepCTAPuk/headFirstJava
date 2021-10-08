package aaa;

public class Q211008_1 {
    {
        System.out.print("1");
    }

    public Q211008_1() {
        System.out.print("2");
    }

    public static void main(String[] args) {
        System.out.print("3");
        Q211008_1 m = new Q211008_1();
        System.out.print("4");
    }

    static {
        System.out.print("5");
    }
}

