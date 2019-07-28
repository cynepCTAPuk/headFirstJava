package chap15_Lambda;

interface MyFunc5<R, T> {
    R func(T n);
}

class MyClass5<T> {
    private T val;

    public MyClass5() {
        val = null;
    }

    public MyClass5(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }
}

class MyClass6 {
    String str;

    public MyClass6() {
        str = "";
    }

    public MyClass6(String str) {
        this.str = str;
    }

    public String getVal() {
        return str;
    }
}
public class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc5<R, T> cons, T v) {
        return cons.func(v);
    }
    public static void main(String[] args) {
        MyFunc5<MyClass5<Double>, Double> myClassCons = MyClass5<Double>::new;
        MyClass5<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("val in ms is " + mc.getVal());

        MyFunc5<MyClass6,String> myClassCons2 = MyClass6::new;
        MyClass6 mc2 = myClassFactory(myClassCons2, "Lambda");
        System.out.println("str in mc2 is " + mc2.getVal());
    }
}
