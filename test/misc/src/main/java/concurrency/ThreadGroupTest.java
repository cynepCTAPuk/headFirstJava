package concurrency;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName()); // main
        System.out.println(threadGroup.activeCount());
        threadGroup.list();

        ThreadGroup threadGroup1 = Thread.currentThread().getThreadGroup().getParent();
        System.out.println(threadGroup1.getName()); // system
        System.out.println(threadGroup1.activeCount());
        threadGroup1.list();

        ThreadGroup threadGroup2 = Thread.currentThread().getThreadGroup().getParent().getParent();
        System.out.println(threadGroup2); // null
    }
}
