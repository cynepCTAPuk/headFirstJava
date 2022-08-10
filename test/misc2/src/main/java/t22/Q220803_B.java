package t22;

abstract class Q220803_A {
    int a = 8;
    public Q220803_A() {
        show();
    }
    abstract void show();
}

public class Q220803_B extends Q220803_A {
    int a = 90;
    void show() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Q220803_B();
    }
}
