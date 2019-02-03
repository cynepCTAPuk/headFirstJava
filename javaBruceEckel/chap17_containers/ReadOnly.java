//: containers/ReadOnly.java
// Using the Collections.unmodifiable methods.
package chap17_containers;
import util.*;
import java.util.*;
import static util.Print.*;
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));
    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        print("c: " + c); // Reading is OK
//        c.add("one"); // Can’t change it
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        print("a: " + a);
        ListIterator<String> lit = a.listIterator();
        print(lit.next()); // Reading is OK
//        lit.add("one"); // Can’t change it

        Set<String> hs = Collections.unmodifiableSet(new HashSet<>(data));
        print("hs: " + hs); // Reading is OK
//        hs.add("one"); // Can’t change it
        // For a SortedSet:
        Set<String> ts = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        print("ts: " + ts); // Reading is OK

        Map<String,String> hm =
                Collections.unmodifiableMap(new HashMap<>(Countries.capitals(5)));
        print("hm: " + hm); // Reading is OK
//        hm.put("Ralph", "Howdy!");
        // For a SortedMap:
        Map<String,String> tm =
                Collections.unmodifiableSortedMap( new TreeMap<>(Countries.capitals(5)));
        print("tm: " + tm); // Reading is OK
    }
} /* Output:
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO]
ALGERIA
[BULGARIA, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA]
{BULGARIA=Sofia, BURKINA FASO=Ouagadougou, BOTSWANA=Gaberone, BENIN=Porto-Novo, ANGOLA=Luanda, ALGERIA=Algiers}
*///:~