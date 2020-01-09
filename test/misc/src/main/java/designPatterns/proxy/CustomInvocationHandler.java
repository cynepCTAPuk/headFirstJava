package designPatterns.proxy;

import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class CustomInvocationHandler implements InvocationHandler {
    private Reader readerOriginal;

    CustomInvocationHandler(Reader readerOriginal) {
        this.readerOriginal = readerOriginal;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("close")) {
            System.out.println("Reader closed!");
        }
        if (method.getName().equals("read")) {
            System.out.println("Reader read");
        }

        // это вызов метода close у объекта readerOriginal
        // имя метода и описание его параметров хранится в переменной method
        return method.invoke(readerOriginal, args);
//        return null;
    }
}