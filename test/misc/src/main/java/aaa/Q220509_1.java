package aaa;

public class Q220509_1 {
    public static void main(String[] args) {
        int i = 33;
        System.out.println(i + " <<1 " + (i << 1));
        System.out.println((char) i + " <<1 " + (char) (i << 1));
        i <<= 1;

        float f = 1;
//        f = f << 1;
        System.out.println(i + ", " + f);
        int count = 0;
        for (int j = 0; j < 1024; j++) {
//            if (Character.isAlphabetic(j))
//            if (Character.isDigit(j))
//            if (Character.isIdentifierIgnorable(j)) {
//            if (Character.isLetter(j)) {
//            if (Character.isLetterOrDigit(j)) {
            if (Character.isIdeographic(j)) {
                System.out.print(j + "->" + (char) j + " ");
                ++count;
            }
        }
        System.out.println("\n" + count);
    }
}

