package chap04;

public class Exercise7 {
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++) {
            if (i == 99) break;
//            if (i == 99) return;
            System.out.print(++j + " ");
        }
    }
}
