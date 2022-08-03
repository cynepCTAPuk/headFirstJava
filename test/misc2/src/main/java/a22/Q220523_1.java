package aaa;

class Q220523 {
    private void fPrivate() {
        System.out.println("f Private");
    }

    public static void fun(Q220523 t) {
        t.fPrivate();
    }

}

public class Q220523_1 extends Q220523 {
    public static void main(String[] args) {
        Q220523 a = new Q220523_1();
//        a.fPrivate();
        Q220523.fun(a);
    }
}

