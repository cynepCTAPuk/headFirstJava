package logicalOps;
public class Swap2 {
    public static void main(String[] args) {
        int a = 5, b = 7;
        int c = b;
        b = a;
        a = c;
    }
}
/*
$ javap -c Swap2.class
Compiled from "Swap2.java"
public class Swap2 {
  public Swap2();
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
       5: iload_2
       6: istore_3
       7: iload_1
       8: istore_2
       9: iload_3
      10: istore_1
      11: return
}
 */