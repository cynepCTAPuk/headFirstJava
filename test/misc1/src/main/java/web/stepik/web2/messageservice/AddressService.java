package web.stepik.web2.messageservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AddressService {
    private final List<Address> dbServices = new ArrayList<>();
    private final AtomicInteger asCounter = new AtomicInteger();

    public Address getDBService() {
        final int index = asCounter.incrementAndGet() % dbServices.size();
        return dbServices.get(index);
    }

    public void addDBService(Address dbService) {
        dbServices.add(dbService);
    }
}
