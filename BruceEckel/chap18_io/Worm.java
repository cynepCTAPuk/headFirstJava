//: io/Worm.java
// Demonstrates object serialization.
package chap18_io;
import java.io.*;
import java.util.*;
import static util.Print.*;

class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;

    // Value of i == number of segments
    public Worm(int i, char x) {
        print("Worm constructor: " + i);
        c = x;
        if (--i > 0) next = new Worm(i, (char) (x + 1));
    }
    public Worm() { print("Default constructor"); }
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d) result.append(dat);
        result.append(")");
        if (next != null) result.append(next);
        return result.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm worm1 = new Worm(3, 'a');
        print("worm1 = " + worm1);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/000/worm.out"));
        out.writeObject("Worm storage 1\n");
        out.writeObject(worm1);
        out.close(); // Also flushes output

        ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("c:/000/worm.out"));
        String str = (String) in1.readObject();
        Worm worm2 = (Worm) in1.readObject();
        print(str + "worm2 = " + worm2);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage 2\n");
        out2.writeObject(worm1);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        str = (String) in2.readObject();
        Worm worm3 = (Worm) in2.readObject();
        print(str + "worm3 = " + worm3);
    }
} /* Output:
Worm constructor: 6
Worm constructor: 5
Worm constructor: 4
Worm constructor: 3
Worm constructor: 2
Worm constructor: 1
w = :a(853):b(119):c(802):d(788):e(199):f(881)
Worm storage
w2 = :a(853):b(119):c(802):d(788):e(199):f(881)
Worm storage
w3 = :a(853):b(119):c(802):d(788):e(199):f(881)
*///:~