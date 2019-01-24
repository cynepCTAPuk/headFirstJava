//: generics/RandomList.java
package chap15_generics;
import java.util.*;

public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) { storage.add(item); }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rls = new RandomList<>();
        String ss = "The quick brown fox jumped over the lazy brown dog";
        for (String s : ss.split(" ")) rls.add(s);
        for (int i = 0; i < 17; i++) System.out.print(rls.select() + " ");

        RandomList<Integer> rli = new RandomList<>();
        Integer[] ints = {1, 2, 3, 10, 20, 30};
        for (Integer i : ints) rli.add(i);
        for (int i = 0; i < 17; i++) System.out.print(rli.select() + " ");

        RandomList<Boolean> rlb = new RandomList<>();
        rlb.add(false);
        rlb.add(true);
        for (int i = 0; i < 17; i++) System.out.print(rlb.select() + " ");


    }
} /* Output:
brown over fox quick quick dog brown The brown lazy brown
*///:~