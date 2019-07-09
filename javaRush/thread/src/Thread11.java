/*
https://javarush.ru//groups//posts//2047-threadom-java-ne-isportishjh--chastjh-i---potoki
 */
public class Thread11 {
    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();

        System.out.println("Thread: " + currentThread.getName());
        System.out.println("\tisAlive? - " + currentThread.isAlive());
        System.out.println("\tisDaemon? - " + currentThread.isDaemon());
        System.out.println("\tisInterrupted? - " + currentThread.isInterrupted());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Parent Group: " + threadGroup.getParent().getName());
    }
}
