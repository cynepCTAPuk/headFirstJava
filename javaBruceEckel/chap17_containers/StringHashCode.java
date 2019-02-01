//: containers/StringHashCode.java
/*
Field type                  Calculation
boolean                     c = ( f ? 0 : 1)
byte, char, short, or int   c = (int)f
long                        c = (int)(f ^ (f>>>32))
float                       c = Float.floatToIntBits(f);
double      long l = Double.doubleToLongBits(f); c = (int)(1 ^ (l>>>32))
Object, where equals( ) calls equals( ) for this field  c = f.hashCode( )
Array                       Apply above rules to each element
result = (int) 17
result = 37 * result + c
 */
package chap17_containers;
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
} /* Output: (Sample)
69609650
69609650
*///:~