//: containers/CountedString.java
// Creating a good hashCode().
package chap17_containers;
import java.util.*;
import static util.Print.*;
public class Exercise26 {
    private static List<String> created = new ArrayList<>();
    private String s;
    private char c;
    private int id = 0;
    public Exercise26(String st, char ch) {
        s = st;
        c = ch;
        created.add(s);
        // id is the total number of instances of this string in use by CountedString:
        for (String s2 : created) if (s2.equals(s)) id++;
    }
    public String toString() {
        return "String: " + s + " char: " + c + " id: " + id + " hashCode(): " + hashCode();
    }
    public int hashCode() {
        // The very simple approach: return s.hashCode() * id;
        // Using Joshua Bloch’s recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + c;
        result = 37 * result + id;
        return result;
    }
    public boolean equals(Object o) {
        return o instanceof Exercise26
                && s.equals(((Exercise26) o).s)
                && c ==((Exercise26) o).c
                && id == ((Exercise26) o).id;
    }

    public static void main(String[] args) {
        Map<Exercise26, Integer> map = new HashMap<>();
        Exercise26[] cs = new Exercise26[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new Exercise26("hi",'a');
            map.put(cs[i], i); // Autoboxing int -> Integer
        }
        print(map);
        for (Exercise26 cstring : cs) {
            print("Looking up " + cstring);
            print(map.get(cstring));
        }
    }
} /* Output: (Sample)
{String: hi id: 4 hashCode(): 146450=3, String: hi id: 1 hashCode(): 146447=0, String: hi id: 3 hashCode(): 146449=2, String: hi id: 5 hashCode(): 146451=4, String: hi id: 2 hashCode(): 146448=1}
Looking up String: hi id: 1 hashCode(): 146447
0
Looking up String: hi id: 2 hashCode(): 146448
1
Looking up String: hi id: 3 hashCode(): 146449
2
Looking up String: hi id: 4 hashCode(): 146450
3
Looking up String: hi id: 5 hashCode(): 146451
4
*///:~