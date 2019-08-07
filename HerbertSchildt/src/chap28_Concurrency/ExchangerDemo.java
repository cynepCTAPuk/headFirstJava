package chap28_Concurrency;

import java.util.concurrent.Exchanger;

// An example of Exchanger
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new UseString(exchanger)).start();
        new Thread(new MakeString(exchanger)).start();
    }
}

// A Thread that constructs a string
class MakeString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public MakeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = new String();
    }

    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            // Fill Buffer
            for (int j = 0; j < 5; j++)
                string += ch++;
            try {
                // Exchange a full buffer for an empty one
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// A Thread that uses a string
class UseString implements Runnable {
    Exchanger<String> exchanger;
    String string;

    public UseString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                // Exchange an empty buffer for a full one
                string = exchanger.exchange(new String());
                System.out.println("Got: " + string);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}