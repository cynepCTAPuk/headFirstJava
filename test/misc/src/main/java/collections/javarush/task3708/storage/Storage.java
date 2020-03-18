package collections.javarush.task3708.storage;

public interface Storage {
    void add(Object storedObject);

    Object get(long id);
}
