package chap11_holding;

//: holding/ListFeatures.java
import typeinfo.pets.*;
import java.util.*;
import static util.Print.*;

public class ListFeaturesIntegers {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        print("1: " + integers);
        Integer h = 1;
        integers.add(h); // Automatically resizes
        print("2: " + integers);
        print("3: " + integers.contains(h));
        integers.remove(h); // Remove by object
        print("3- " + integers);
        Integer p = integers.get(2);
        print("4: " + p + " " + integers.indexOf(p));
        Pet cymric = new Cymric();
        print("5: " + integers.indexOf(cymric));
        print("6: " + integers.remove(cymric));
        // Must be the exact object:
        print("7: " + integers.remove(p));
        print("8: " + integers);
        integers.add(3, 9); // Insert at an index
        print("9: " + integers);

        List<Integer> sub = integers.subList(1, 4);
        print("subList: " + sub);
        print("10: " + integers.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
        // Order is not important in containsAll():
        print("11: " + integers.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + integers.containsAll(sub));

        List<Integer> copy = new ArrayList<>(integers);
        sub = Arrays.asList(integers.get(1), integers.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<Integer>(integers); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        print("15: " + copy);
        copy.set(1, 16); // Replace an element
        print("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        print("17: " + copy);
        print("18: " + integers.isEmpty());
        integers.clear(); // Remove all elements
        print("19: " + integers);
        print("20: " + integers.isEmpty());
        integers.addAll(sub);
        integers.addAll(sub);
        print("21: " + integers);
        Object[] obj = integers.toArray();
        print("22: " + obj[3]);
        print("22- " + Arrays.toString(obj));
    }
} /* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 14
*///:~