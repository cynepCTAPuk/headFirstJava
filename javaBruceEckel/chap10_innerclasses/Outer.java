package chap10_innerclasses;

public class Outer {
    private String string;
    private Outer(String string) { this.string = string; }
    private class Inner {
        public String toString(){ return string; }
    }

    private Inner call() { return new Inner(); }

    public static void main(String[] args) {
        Inner inner = new Outer("abc").call();
        System.out.println(inner);
    }
}
