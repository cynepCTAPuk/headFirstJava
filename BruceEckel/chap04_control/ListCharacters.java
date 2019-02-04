package chap04_control;

//: control/ListCharacters.java
// Demonstrates "for" loop by listing
// all the lowercase ASCII letters.
public class ListCharacters {
    public static void main(String[] args) {
        int i = 0, j = 0, k = 0;
/*
        for (char c = 0; c < 128; c++) {
            if (Character.isLowerCase(c)) System.out.print((int) c + ":" + c + " ");
            if (++i % 10 == 0) System.out.println();
        }
*/
/*
        for (char c = 0; c < 128; c++) {
            if (Character.isLetter(c)) System.out.print((int) c + ":" + c + " ");
            if (++j % 10 == 0) System.out.println();
        }
*/
        for (char c = 0; c < 128; c++) {
            if (Character.isUpperCase(c)) System.out.print((int) c + ":" + c + " ");
            if (++k % 10 == 0) System.out.println();
        }
    }
} /* Output:
value: 97 character: a
value: 98 character: b
value: 99 character: c
value: 100 character: d
value: 101 character: e
value: 102 character: f
value: 103 character: g
value: 104 character: h
value: 105 character: i
value: 106 character: j
*///:~