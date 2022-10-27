package y22;

public class Q220801_1 {
    public static void main(String[] args) {
        Q220801A a = new Q220801B();
        a.test(5);
    }
}

class Q220801A {
    public void test(Object obj) {
        System.out.println("Object=" + obj);
    }
}

class Q220801B extends Q220801A {
    public void test(Integer obj) {
        System.out.println("Integer=" + obj);
    }
}