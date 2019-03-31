package ru.otus;

//import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MyClass {
    public static void main(String[] args) {
//        test(args.length == 1 ? args[0] : "NoName");
//        test(Lists.asList("Sully", args).toString());
//        resourcesExample();
        test("Sully");
    }

    private static void test(String name) {
        System.out.println("Hello " + name);
    }

    private static void resourcesExample() {
        URL url = MyClass.class.getResource("/resources/hello.txt");
        System.out.println(url);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
