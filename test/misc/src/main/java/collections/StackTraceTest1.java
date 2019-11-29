package collections;

public class StackTraceTest1 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);
        System.out.println(stackTraceElements[2].getMethodName());
    }

    public static void method2() {
        method3();
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);
        System.out.println(stackTraceElements[2].getMethodName());
    }

    public static void method3() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements.length);
        System.out.println(stackTraceElements[2].getMethodName());
    }
}
