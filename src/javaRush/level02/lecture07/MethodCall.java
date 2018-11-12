package javaRush.level02.lecture07;

public class MethodCall {
  public static void main(String[] args) {
    print4("I like to move it, move it.");
    int a = 5, b = 7;
    int m = min(a, b);
    System.out.println("Minimum is " + m);
  }

  public static void print4(String s) {
    System.out.println(s);
    System.out.println(s);
    System.out.println(s);
    System.out.println(s);
  }

  public static int min(int c, int d) {
    int m2;
    if (c < d) m2 = c;
    else m2 = d;
    return m2;
  }
}