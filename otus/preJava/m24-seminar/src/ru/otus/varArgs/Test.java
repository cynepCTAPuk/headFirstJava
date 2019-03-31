package ru.otus.varArgs;

import java.text.MessageFormat;
import java.util.Date;

public class Test extends Object {
    Object[] arguments = {
            7,
            new Date(),
            "a disturbance in the Force"};

    String result = MessageFormat.format(
            "At {1,time} on {1,date}, there was {2} on planet " +
                    "{0,number,integer}.", arguments);

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;
        for (String className : args) {
            try {
                Class c = Class.forName(className);
//                c.getMethod("test").invoke(c.newInstance());
                passed++;
            } catch (Exception ex) {
                System.out.printf("%s failed: %s%n", className, ex);
                failed++;
            }
        }
        System.out.printf("passed=%d; failed=%d%n", passed, failed);
        System.out.println(new Test().arguments.toString());
        System.out.println(new Test().result);
    }
}