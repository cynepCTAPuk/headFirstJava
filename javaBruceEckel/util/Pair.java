//: net/mindview/util/Pair.java
package util;

public class Pair<K, V> {
    public K key;
    public final V value;

    public Pair(K k, V v) {
        value = v;
    }
} ///:~