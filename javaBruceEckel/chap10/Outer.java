package chap10;

public class Outer {
    class Inner { }
    Inner call() { return new Inner(); }

    public static void main(String[] args) {
        Inner inner = new Outer().call();
        System.out.println(inner);
    }
}
