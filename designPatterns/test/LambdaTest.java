package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String e) {
                Methods.print1(e);
            }
        });
        list.forEach(e -> Methods.print2(e));
        list.forEach(Methods::print3);
    }

}
class Methods{
    static void print1(String e) {System.out.print(e + ", ");}
    static void print2(String e) {System.out.print(e + "; ");}
    static void print3(String e) {System.out.print(e + " ");}
}
