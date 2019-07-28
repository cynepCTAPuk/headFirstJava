package chap15_Lambda;

interface MyFunc4<T> {
    MyClass4<T> func(T n);
}

class MyClass4<T> {
    private T val;

    public MyClass4() {
        val = null;
    }

    public MyClass4(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc4<Integer> myClassCons = MyClass4<Integer>::new;
        MyClass4<Integer> mc = myClassCons.func(100);
        System.out.println("val in mc is " + mc.getVal());
    }
}
