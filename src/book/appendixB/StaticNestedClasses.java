package book.appendixB;

public class StaticNestedClasses {
    public static void main(String[] args) {
        FooOuter.BarInner foo = new FooOuter.BarInner();
        foo.sayIt();
    }
}

class FooOuter {
    static class BarInner {
        void sayIt() {
            System.out.println("method of a static inner class");
        }
    }
}