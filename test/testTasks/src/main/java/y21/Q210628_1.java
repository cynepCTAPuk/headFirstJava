package y21;

public class Q210628_1 {
    public static final int N = 5;

    public static void main(String[] args) {
        int m[][][] = new int[N][N][N];
        label:
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++) {
                    m[i][j][k] = i * j * k;
                    if (m[i][j][k] == 9) {
                        System.out.print(" 9");
//                        goto label;
                    }
                }
    }
}

