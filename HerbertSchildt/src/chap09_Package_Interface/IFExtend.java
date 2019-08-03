package chap09_Package_Interface;

interface A1 {
    void meth1();

    void meth2();
}

interface B1 extends A1 {
    void meth3();
}

class MyClass implements B1 {
    @Override
    public void meth1() {
        System.out.println("Implement meth1()");
    }

    @Override
    public void meth2() {
        System.out.println("Implement meth2()");
    }

    @Override
    public void meth3() {
        System.out.println("Implement meth3()");
    }
}

public class IFExtend {
    public static void main(String[] args) {
        MyClass ob = new MyClass();
        ob.meth1();
        ob.meth2();
        ob.meth3();
    }
}
