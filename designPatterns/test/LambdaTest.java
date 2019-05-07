package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    private interface A {
        int valueA(String s);
    }

    private interface B {
        int valueB(String s);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
/*
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String e) {
                Methods.print1(e);
            }
        });
        list.forEach(e -> Methods.print2(e));
        list.forEach(Methods::print3);
*/
/*
        System.out.println(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                return e2.compareTo(e1);
            }
        });
        System.out.println(list);
        list.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        System.out.println(list);
*/
        A a = String::length;
        B b;

//        b = a; // Ошибка компилятора!
//        b = (B) a; // ClassCastException на этапе исполнения!
        b = a::valueA; // работает с использованием ссылки на метод
        System.out.println(a);
        System.out.println(b);

        System.out.println(b.valueB("abc"));
    }

}

class Methods {
    static void print1(String e) {
        System.out.print(e + ", ");
    }

    static void print2(String e) {
        System.out.print(e + "; ");
    }

    static void print3(String e) {
        System.out.print(e + " ");
    }
}
