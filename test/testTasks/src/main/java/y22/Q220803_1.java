package y22;

abstract class Q220803 {
    int a = 8;
    public Q220803() {
        show();
    }
    abstract void show();
}

public class Q220803_1 extends Q220803 {
    int a = 90;
    void show() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new Q220803_1();
    }
}
