//: generics/RandomList.java
package chap15_generics;
import java.util.*;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rls = new RandomList<>();
        String string = "The quick brown fox jumped over the lazy brown dog";
        for (String s : string.split(" ")) rls.add(s);
        for (int i = 0; i < 17; i++) System.out.print(rls.select() + " ");
    }
} /* Output:
brown over fox quick quick dog brown The brown lazy brown
*///:~