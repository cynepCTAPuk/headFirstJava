//: io/UsingRandomAccessFile.java
package chap18_io;
import java.io.*;

public class Exercise16 {
    static String file = "c:/000/UsingRandomAccessFile.dat";

    static void display() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        for(int i = 0; i < 7; i++) System.out.println( "Value " + i + ": " + raf.readDouble());
//        System.out.println(raf.readUTF());
        raf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for(int i = 0; i < 7; i++) raf.writeDouble(i*1.414);

//        raf.writeUTF("The end of the file");
        System.out.println(raf.length() + "\n");
        raf.close();
        display();
        System.out.println();

        raf = new RandomAccessFile(file, "rw");
        raf.seek(5*8);
        raf.writeDouble(47.0001);
        raf.close();
        display();
    }
} /* Output:
Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 7.069999999999999
Value 6: 8.484
The end of the file
Value 0: 0.0
Value 1: 1.414
Value 2: 2.828
Value 3: 4.242
Value 4: 5.656
Value 5: 47.0001
Value 6: 8.484
The end of the file
*///:~