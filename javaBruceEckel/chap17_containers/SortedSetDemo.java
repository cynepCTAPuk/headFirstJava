//: containers/SortedSetDemo.java
// What you can do with a TreeSet.
package chap17_containers;
import java.util.*;
import static util.Print.*;
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        String s = "one two three four five six seven eight";
        System.out.println(s);
        Collections.addAll(sortedSet, s.split("\\W+"));
        print(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        print("low:\t" + low);
        print("high:\t" + high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }
        print("low:\t" + low);
        print("high:\t" + high);
        print("subSet(low, high):\t" + sortedSet.subSet(low, high));
        print("headSet(high):\t\t" + sortedSet.headSet(high));
        print("tailSet(low):\t\t" + sortedSet.tailSet(low));
    }
} /* Output:
[eight, five, four, one, seven, six, three, two]
eight
two
one
two
[one, seven, six, three]
[eight, five, four, one, seven, six, three]
[one, seven, six, three, two]
*///:~