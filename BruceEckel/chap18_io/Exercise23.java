//: io/BufferToText.java
// Converting text to and from ByteBuffers
package chap18_io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Exercise23 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("c:/000/data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("c:/000/data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        // Doesn’t work:
        System.out.println("1: Read by default: " + buff.asCharBuffer());

        // Decode using this system’s default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("2: Read by charset getting System.getProperty(\"file.encoding\"): "
                + encoding + ": " + Charset.forName(encoding).decode(buff));

        // Or, we could encode with something that will print:
        fc = new FileOutputStream("c:/000/data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        fc.close();

        // Now try reading again:
        fc = new FileInputStream("c:/000/data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("3: Write by charset \"UTF-16BE\" and read by CharBuffer: "
                + buff.asCharBuffer());

        // Use a CharBuffer to write through:
        fc = new FileOutputStream("c:/000/data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); // More than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();

        // Read and display:
        fc = new FileInputStream("c:/000/data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println("4: Use a CharBuffer to write through: " + buff.asCharBuffer());
    }
} /* Output:
????
Decoded using Cp1252: Some text
Some text
Some text
*///:~