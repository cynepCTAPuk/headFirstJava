package beginning.inheritance;

public class POSIXTimeSupplier extends TimeSupplier {
    @Override
    public long getTime() {
        return super.getTime() / 1000;
    }
}
