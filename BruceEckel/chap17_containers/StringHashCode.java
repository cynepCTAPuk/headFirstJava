//: containers/StringHashCode.java
/*
In Effective Java™ Programming Language Guide (Addison-Wesley, 2001),
Joshua Bloch gives a basic recipe for generating a decent hashCode( ):
1. Store some constant nonzero value, say 17, in an int variable called result.
2. For each significant field fin your object (that is, each field taken into
    account by the equals( ) method),  calculate an int hash code c for the field:
Field type                  Calculation
boolean                     c = ( f ? 0 : 1)
byte, char, short, or int   c = (int)f
long                        c = (int)(f ^ (f>>>32))
float                       c = Float.floatToIntBits(f);
double                      long l = Double.doubleToLongBits(f);
                            c = (int)(1 ^ (l>>>32))
Object, where equals( ) calls equals( ) for this field
                            c = f.hashCode( )
Array                       Apply above rules to each element
3. Combine the hash code(s) computed above: result = 37 * result + c;
4. Return result.
5. Look at the resulting hashCode( ) and make sure that equal instances have equal hash codes. */
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