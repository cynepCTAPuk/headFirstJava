package patterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton.instance().setMessage("Hello");
        new SingletonTest().print();
    }

    private void print() {
        System.out.println(Singleton.instance().getMessage());
    }
}
