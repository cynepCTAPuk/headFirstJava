package beginning.references;

import beginning.inheritance.POSIXTimeSupplier;
import beginning.inheritance.TimeSupplier;
import beginning.inheritance.TimeSupplierInterface;

import java.util.ArrayList;

public class TimeHolderTest {

    public static void main(String[] args) {
        TimeSupplierInterface timeSupplier1 = new TimeSupplier();
        TimeHolder holder1 = new TimeHolder(timeSupplier1);
        holder1.printTime();
        holder1.setTimeSupplier(new POSIXTimeSupplier());
        holder1.printTime();

        ArrayList<String> arrayList = new ArrayList();
        System.out.println(arrayList.size());
    }
}
