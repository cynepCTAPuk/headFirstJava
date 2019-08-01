package chap09_Package_Interface;

public class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherClient();
        c.callback(42);

        c = ob; // c now refers to AnotherClient objetc
        c.callback(42);
    }
}
