package ru.otus.l011;

public class Hello {
  public static void main(String[] args) {
    String word = "HELLO";
//    for (char c : word.toCharArray()) System.out.println(c);
    char cc = 'Ф';
    System.out.println("cc = " + cc);

    int ii = cc;
    System.out.println("ii = " + ii);

    ii = (1 << 16) + 1060;
    cc = (char) ii;
    System.out.println("ii = " + Integer.toBinaryString(ii) + "\tcc = " + cc);

    cc = 1061;
    System.out.println("cc = " + cc);
  }
}
