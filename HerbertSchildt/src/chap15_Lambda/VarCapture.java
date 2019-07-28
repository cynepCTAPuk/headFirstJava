package chap15_Lambda;

interface MyFunc {
    int func(int n);
}

public class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);

        MyFunc myLambda = n -> {
            int v = 0;
//            v = num + n;  // illegal use num
//            num++;        // illegal use num
            return v;
        };

        num = 9;
        System.out.println(num);
    }
}
