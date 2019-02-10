//: io/FreezeAlien.java
// Create a serialized output file.
package chap18_io;
import java.io.*;
public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream( new FileOutputStream("c:/000/X.file"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
} ///:~