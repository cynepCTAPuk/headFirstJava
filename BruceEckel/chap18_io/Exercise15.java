//: io/StoringAndRecoveringData.java
package chap18_io;

import java.io.*;

public class Exercise15 {
    public static void main(String[] args) throws IOException {
        String file = "c:/000/DataOutputStream.txt";
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)));
        out.writeBoolean(true);
        out.writeByte(10);
//        out.writeBytes("Bytes");
        out.writeChar('z');
//        out.writeChars("Chars");
        out.writeDouble(3.14159);
        out.writeFloat(1000f);
        out.writeInt(99);
        out.writeLong(959L);
        out.writeShort(125);
        out.writeUTF("UTF");
        System.out.println("out.size(): " + out.size());
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readBoolean());
        System.out.println(in.readByte());
//        System.out.println(in.readBytes());
        System.out.println(in.readChar());
//        System.out.println(in.readChars());
        System.out.println(in.readDouble());
        System.out.println(in.readFloat());
        System.out.println(in.readInt());
        System.out.println(in.readLong());
        System.out.println(in.readShort());
        System.out.println(in.readUTF());
    }
} /* Output:
3.14159
That was pi
1.41413
Square root of 2
*///:~