//: holding/CollectionSequence.java
package chap11_holding;
import chap14_typeinfo.pets.*;
import java.util.*;
public class Exercise30 implements Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    public int size() { return pets.length; }
    public Iterator<Pet> iterator() {
        return new Iterator<>() {
            private int index = 0;
            public boolean hasNext() { return index < pets.length; }
            public Pet next() { return pets[index++]; }
            // Not implemented
            public void remove() { throw new UnsupportedOperationException(); }
        };
    }

    public Object[] toArray() { return new Object[0]; }
    public <T> T[] toArray(T[] a) { return null; }
    public boolean add(Pet pet) { return false; }
    public boolean addAll(Collection<? extends Pet> c) { return false; }
    public boolean contains(Object o) { return false; }
    public boolean containsAll(Collection<?> c) { return false; }
    public boolean isEmpty() { return false; }
    public boolean remove(Object o) { return false; }
    public boolean removeAll(Collection<?> c) { return false; }
    public boolean retainAll(Collection<?> c) { return false; }
    public void clear() { }

    public static void main(String[] args) {
        Exercise30 c = new Exercise30();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
*///:~