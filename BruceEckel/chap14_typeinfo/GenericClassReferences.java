package chap14_typeinfo;//: typeinfo/chap14_typeinfo.GenericClassReferences.java

public class GenericClassReferences {
  public static void main(String[] args) {
    Class intClass = int.class;
    Class<Integer> genericIntClass = int.class;
    genericIntClass = Integer.class; // Same thing
    intClass = double.class;
    // genericIntClass = double.class; // Illegal
  }
} ///:~
