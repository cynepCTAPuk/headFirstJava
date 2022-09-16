package chars;

public class PrintChars {
    public static void main(String[] args) {
        int a = (1 << 10) - (1 << 7);
        int b = 1 << 10;
        for (int i = a; i < b; i++) {
//            System.out.print(i + ":" + (char) i + " ");
//            System.out.print((char) i + " ");
            System.out.print((char) ('\\' + i) + " ");
        }
        System.out.println();
        System.out.println(Integer.toString(255, 2));
    }
}
