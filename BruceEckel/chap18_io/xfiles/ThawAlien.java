//: io/xfiles/ThawAlien.java
// Try to recover a serialized file without the
// class of object that’s stored in that file.
// {RunByHand}
package chap18_io.xfiles;
import java.io.*;
public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("c:/000/X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
} /* Output:
class Alien
*///:~