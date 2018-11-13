package chap12;

import java.util.function.*;

public class LambdaExp {

    final static String GREETING = "Hi ";

    public static void main(String[] args) {
        Consumer<String> c = (s) -> System.out.println(GREETING + s+"!");
        c.accept("CTAPuk");
    }
}