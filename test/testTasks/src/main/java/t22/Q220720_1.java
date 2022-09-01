package t22;

public class Q220720_1 {
    public static void main(String[] args) {
        try {
            Q220720_1_1.run();
        } catch (Throwable t) {
            Q220720_1_1.run();
        }
    }
}

class Q220720_1_1 {
    static void run() {
        if (true) throw new NullPointerException();
    }
}