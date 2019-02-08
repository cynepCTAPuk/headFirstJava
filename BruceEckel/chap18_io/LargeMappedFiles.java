//: io/LargeMappedFiles.java
// Creating a very large file using mapping.
// {RunByHand}
package chap18_io;
import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import static util.Print.*;
public class LargeMappedFiles {
    static int length = 0x7FFFFFF; // 128 MB
    public static void main(String[] args) throws Exception {
        MappedByteBuffer out =
                new RandomAccessFile("c:/000/test.dat", "rw")
                        .getChannel()
                        .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for(int i = 0; i < length; i++) out.put((byte)'x');
        print("Finished writing");
        for(int i = length/2; i < length/2 + 6; i++) printnb((char)out.get(i));
    }
} ///:~