package algorithms;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.printf("%,d%n",Integer.MAX_VALUE);
//        System.out.printf("%,d%n",Integer.MAX_VALUE/2);
/*
        for (int i = 32; i < 256; i++) {
            if (!Character.isIdentifierIgnorable(i))
                System.out.print(i + ":" + (char) i + " ");
        }
*/
/*
        Scanner scanner = new Scanner(new File("c:/000/input.txt"));
        while (scanner.hasNext()) System.out.print(scanner.nextInt() + " ");
*/
//        System.out.printf("%e",(double)Integer.MIN_VALUE);
//        System.out.println((int) '\u2260');
        int n = 8700;
        for (int i = n; i < n + 100; i++) {
            System.out.print(i + ":" + (char) i + " ");
        }
    }
}
