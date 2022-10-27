package y22;

public class Q220204_1 {
    public static void main(String[] args) {
        Base sub = new Sub();
        sub.test();
        Sub.test();
        Base.test();
    }
}

class Base {
    public static void test() {
        System.out.println("Base.test()");
    }
}

class Sub extends Base {
    public static void test() {
        System.out.println("Sub.test()");
    }
}

