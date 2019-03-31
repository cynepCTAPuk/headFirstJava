package beginning.inheritance;

public class TimeSupplierTest {
    public void printTime(TimeSupplier timeSupplier) {
        System.out.println("POSIX time: " + timeSupplier.getTime());
    }

    public static void main(String[] args) {
        TimeSupplier timeSupplier = new TimeSupplier();
        new TimeSupplierTest().printTime(timeSupplier);
    }
}
