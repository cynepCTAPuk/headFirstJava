//: typeinfo/WildcardClassReferences.java
package chap14_typeinfo;

public class WildcardClassReferences {
  public static void main(String[] args) {
    Class<?> intClass = int.class;
    intClass = double.class;
  }
} ///:~
