package recursion;

public class CountDown {
    public static void main(String[] args) throws InterruptedException {
        countDown(10);
    }

    public static void countDown(int x) throws InterruptedException {
        if (x <= 0)
            System.out.println("Boom!");
        else {
            System.out.println(x);
            Thread.sleep(1_000);
            countDown(x - 1);
            Thread.sleep(1_000);
            System.out.println(x);
        }
    }
}
