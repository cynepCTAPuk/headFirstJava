package web.stepik.web2.messageservice;

import java.util.concurrent.atomic.AtomicInteger;

public class Address {
    private static AtomicInteger abonentIdCreator = new AtomicInteger();
    final private int abonentId;

    public Address() {
        this.abonentId = abonentIdCreator.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return abonentId == address.abonentId;
    }

    @Override
    public int hashCode() {
        return abonentId;
    }
}
