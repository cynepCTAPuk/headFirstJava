package chap09_Package_Interface;

public class AnotherClient implements Callback {
    @Override
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + p * p);
    }

    void nonIfaceMeth() {
        System.out.println("Classes that implement interfaces may also define other members, too.");
    }
}
