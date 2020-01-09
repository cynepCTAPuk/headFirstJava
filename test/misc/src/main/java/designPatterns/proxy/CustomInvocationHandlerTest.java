package designPatterns.proxy;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;

/**
 * https://javarush.ru/quests/lectures/questcollections.level02.lecture07
 */
public class CustomInvocationHandlerTest {
    public static void main(String[] args) throws IOException {
        Reader original = new UserCustomReader();

        ClassLoader classLoader = original.getClass().getClassLoader();
        Class<?>[] interfaces = original.getClass().getInterfaces();
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(original);

//        Reader reader = (Reader) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
//        Closeable reader = (Closeable) Proxy.newProxyInstance(Reader.class.getClassLoader(), Reader.class.getInterfaces(), new CustomInvocationHandler(original));
        Closeable reader = (Closeable) Proxy.newProxyInstance(Reader.class.getClassLoader(), Reader.class.getInterfaces(), invocationHandler);

        reader.close();
    }
}
