package chap15_Lambda;

interface MyFunc3 {
    MyClass3 func(int n);
}

class MyClass3 {
    private int val;

    public MyClass3() {
        val = 0;
    }

    public MyClass3(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc3 myClassCons = MyClass3::new;
        MyClass3 mc = myClassCons.func(100);
        System.out.println("val in mc is " + mc.getVal());
    }
}
