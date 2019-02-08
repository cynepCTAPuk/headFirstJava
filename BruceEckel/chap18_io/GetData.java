//: io/GetData.java
// Getting different representations from a ByteBuffer
package chap18_io;

import java.nio.*;

import static util.Print.*;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0) print("nonzero");
        print("i = " + i);
        bb.rewind();

        // Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0) printnb(c + " ");
        print();
        bb.rewind();

        // Store and read a short:
        bb.asShortBuffer().put((short) 471_142);
        print("short: \t" + bb.getShort());
        bb.rewind();

        // Store and read an int:
        bb.asIntBuffer().put(99_471_142);
        print("int: \t" + bb.getInt());
        bb.rewind();

        // Store and read a long:
        bb.asLongBuffer().put(99_471_142);
        print("long: \t" + bb.getLong());
        bb.rewind();

        // Store and read a float:
        bb.asFloatBuffer().put(99_471_142);
        print("float:\t" + bb.getFloat());
        bb.rewind();

        // Store and read a double:
        bb.asDoubleBuffer().put(99_471_142);
        print("double:\t" + bb.getDouble());
        bb.rewind();
    }
} /* Output:
i = 1025
H o w d y !
12390
99471142
99471142
9.9471144E7
9.9471142E7
*///:~