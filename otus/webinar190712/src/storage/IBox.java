package storage;

public interface IBox {

    int size();

    void put(String item);

    String get(int index);

    boolean has(String item);
}
