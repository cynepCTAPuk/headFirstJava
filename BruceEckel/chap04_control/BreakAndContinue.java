package chap04_control;

import static util.Range.*;

//: control/BreakAndContinue.java
// Demonstrates break and continue keywords.
public class BreakAndContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 74) break;         // Out of for loop
            if (i % 9 != 0) continue;   // Next iteration
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : range(100)) {  // Using foreach:
            if (i == 74) break;         // Out of for loop
            if (i % 9 != 0) continue;   // Next iteration
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 0;
        while (true) {                  // An "infinite loop":
            i++;
            int j = i * 27;
            if (j == 1269) break;       // Out of loop
            if (i % 10 != 0) continue;  // Top of loop
            System.out.print(i + " ");
        }
    }
} /* Output:
0 9 18 27 36 45 54 63 72
0 9 18 27 36 45 54 63 72
10 20 30 40
*///:~