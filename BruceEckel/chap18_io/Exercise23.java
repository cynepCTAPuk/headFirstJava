//: io/BufferToText.java
// Converting text to and from ByteBuffers
package chap18_io;

import java.util.*;

public class Exercise23 {

    public static void main(String[] args) {
        Map treeMap = new TreeMap(System.getProperties());
        Iterator it = treeMap.keySet().iterator();
        while (it.hasNext()) {
            Object k = it.next();
            Object v = treeMap.get(k);
            System.out.println(k + ": " + v);
        }
    }
}