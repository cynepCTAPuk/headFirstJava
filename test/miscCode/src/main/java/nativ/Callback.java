package nativ;

public class Callback {
    private final String transport;

    public Callback(String transport) {
        this.transport = transport;
    }

    public void call() {
        System.out.println("Ok, we are in Shire again! Returned by " + transport);
    }
}
