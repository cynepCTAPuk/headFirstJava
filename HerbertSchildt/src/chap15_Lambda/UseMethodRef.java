package chap15_Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyClass {
    private int val;

    public MyClass(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public class UseMethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        List<MyClass> a1 = new ArrayList<>();
        a1.add(new MyClass(1));
        a1.add(new MyClass(4));
        a1.add(new MyClass(2));
        a1.add(new MyClass(9));
        a1.add(new MyClass(3));
        a1.add(new MyClass(7));
        MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMC);
        System.out.println("Maximum value is: " + maxValObj.getVal());
    }
}
