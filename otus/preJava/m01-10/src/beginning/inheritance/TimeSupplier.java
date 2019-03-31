package beginning.inheritance;

public class TimeSupplier implements TimeSupplierInterface{
    public long getTime() {
        return System.currentTimeMillis();
    }
}
