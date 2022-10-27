package y21;

public class Q210630_1 {
    public static final int N = 5;

    public static void main(String[] args) {
        label:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 2) break label;
                System.out.print(j);
            }
            System.out.print(" ");
        }
    }
}

