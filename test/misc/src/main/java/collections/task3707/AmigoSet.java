package collections.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        double capacity = Math.max(16, collection.size() / .75f + 1);
        map = new HashMap<>((int) capacity);
        for (E e : collection) map.put(e, PRESENT);
    }

    public boolean add(Object e) {
        return map.put((E) e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(map.get(o)) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet result = new AmigoSet(this);
            result.map = (HashMap) map.clone();
            return result;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        outputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        outputStream.writeInt(size());
        for (E e : map.keySet()) outputStream.writeObject(e);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        int capacity = inputStream.readInt();
        float loadFactor = inputStream.readFloat();
        int size = inputStream.readInt();
        map = new HashMap<>(capacity, loadFactor);
        for (int i = 0; i < size; i++) map.put((E) inputStream.readObject(), PRESENT);
    }
}
