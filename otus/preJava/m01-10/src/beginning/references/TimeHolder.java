package beginning.references;

import beginning.inheritance.TimeSupplierInterface;

public class TimeHolder {
    private TimeSupplierInterface timeSupplier;

    public TimeHolder(TimeSupplierInterface timeSupplier) {
//        this.timeSupplier = timeSupplier;
        setTimeSupplier(timeSupplier);
    }

    public void printTime() {
        System.out.println("POSIX: " + timeSupplier.getTime());
    }

    public void setTimeSupplier(TimeSupplierInterface supplier) {
        timeSupplier = supplier;
    }
}
