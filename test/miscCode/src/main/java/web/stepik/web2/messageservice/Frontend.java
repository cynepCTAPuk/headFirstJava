package web.stepik.web2.messageservice;

public class Frontend implements Abonent, Runnable {
    private final MessageSystem ms;
    private Address address;

    public Frontend(MessageSystem ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        while (true) {
            ms.execForAbonent(this);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
