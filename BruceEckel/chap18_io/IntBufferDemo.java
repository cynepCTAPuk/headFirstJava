//: io/IntBufferDemo.java
// Manipulating ints in a ByteBuffer with an IntBuffer
package chap18_io;
import java.nio.*;
    public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // Store an array of int:
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016}); // Absolute location read and write:
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.printf("%4d ", i);
        }
        System.out.println("\n" + ib.get(3));
        ib.put(3, 1_811); // Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.printf("%4d ", i);
        }
    }
} /* Output:
99
11
42
47
1811
143
811
1016
*///:~