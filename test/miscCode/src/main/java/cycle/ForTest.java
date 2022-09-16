package cycle;

public class ForTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) break;
            }
            System.out.println(i+ ": After break");
        }
    }
}
