//: io/StoringAndRecoveringData.java
package chap18_io;

import java.io.*;

public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String file = "c:/000/Data.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readDouble());
        // Only readUTF() will recover the Java-UTF String properly:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        long[] ints = {
                0x40, 0x09, 0x21, 0xf9, 0xf0, 0x1b, 0x86, 0x6e, 0x00, 0x0b, 0x54, 0x68, 0x61,
                0x74, 0x20, 0x77, 0x61, 0x73, 0x20, 0x70, 0x69, 0x3f, 0xf6, 0xa0, 0x46, 0xc7,
                0x64, 0xae, 0x00, 0x00, 0x10, 0x53, 0x71, 0x75, 0x61, 0x72, 0x65, 0x20, 0x72,
                0x6f, 0x6f, 0x74, 0x20, 0x6f, 0x66, 0x20, 0x32};
        for (long i : ints) {
            System.out.print((char)i);
        }
    }
} /* Output:
3.14159
That was pi
1.41413
Square root of 2
*///:~