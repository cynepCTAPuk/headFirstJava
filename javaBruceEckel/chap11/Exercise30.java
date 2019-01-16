//: holding/CollectionSequence.java
package chap11;
import typeinfo.pets.*;
import java.util.*;
public class Exercise30 extends AbstractCollection<Pet> {
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
    public static void main(String[] args) {
        Exercise30 c = new Exercise30();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
} /* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
*///:~