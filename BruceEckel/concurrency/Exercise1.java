package concurrency;

class A implements Runnable{
    A() { System.out.println("Create object A");}
    @Override
    public void run() {
        System.out.println("----- Start A");
        for (int i = 0; i < 3 ; i++) {
            System.out.println("A:" + i);
            Thread.yield();
        }
        System.out.println("Finish A");
    }
}
class B implements Runnable{
    B() { System.out.println("Create object B");}
    @Override
    public void run() {
        System.out.println("----- Start B");
        for (int i = 0; i < 3 ; i++) {
            System.out.println("B:" + i);
            Thread.yield();
        }
        System.out.println("Finish B");
    }
}
class C implements Runnable{
    C() { System.out.println("Create object C");}
    @Override
    public void run() {
        System.out.println("----- Start C");
        for (int i = 0; i < 3 ; i++) {
            System.out.println("C: " + i);
            Thread.yield();
        }
        System.out.println("Finish C");
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("***** Beginning *****");
        for (int i = 0; i < 2 ; i++) {
            new Thread(new A()).start();
            new Thread(new B()).start();
            new Thread(new C()).start();
        }
        System.out.println("***** Ending *****");

    }
}
