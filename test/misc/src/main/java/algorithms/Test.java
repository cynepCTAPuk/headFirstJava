package algorithms;

public class Test {
    public static void main(String[] args) {
//        System.out.printf("%,d%n",Integer.MAX_VALUE);
//        System.out.printf("%,d%n",Integer.MAX_VALUE/2);
        for (int i = 32; i < 256; i++) {
            if (!Character.isIdentifierIgnorable(i))
                System.out.print(i + ":" + (char) i + " ");
        }
    }
}
