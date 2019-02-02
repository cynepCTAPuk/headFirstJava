package logicalOps;

public class Swap1 {
    public static void main(String[] args) {
        int a = 5, b = 7;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
/*
$ javap -c Swap1.class
Compiled from "Swap1.java"
public class Swap1 {
  public Swap1();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: iconst_5
       1: istore_1
       2: bipush        7
       4: istore_2
       5: iload_1
       6: iload_2
       7: ixor
       8: istore_1
       9: iload_1
      10: iload_2
      11: ixor
      12: istore_2
      13: iload_1
      14: iload_2
      15: ixor
      16: istore_1
      17: return
}
 */