package chap06_Interfaces.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates the use of proxies.
 *
 * @author Cay Horstmann
 * @version 1.01 2018-04-10
 */
public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[1_000];
        // fill elements with proxies for the integers 1 . . . 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1; // construct a random integer
        int result = Arrays.binarySearch(elements, key); // search for the key
        if (result >= 0) System.out.println(elements[result]); // print match if found
    }
}

/**
 * An invocation handler that prints out the method name and parameters, then
 * invokes the original method
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    /**
     * Constructs a TraceHandler
     *
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.print(target);   // print implicit argument
        System.out.print("." + m.getName() + "(");  // print method name
        if (args != null) { // print explicit arguments
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return m.invoke(target, args); // invoke actual method
    }
}
