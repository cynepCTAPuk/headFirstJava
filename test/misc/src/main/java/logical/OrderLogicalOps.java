package logical;

public class OrderLogicalOps {
    public static void main(String[] args) {
        boolean[] booleans = new boolean[4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < booleans.length; j++) {
                booleans[j] = !(Math.random() < 0.5);
            }
            for(boolean b: booleans) System.out.print(b + " ");
            System.out.println();
            boolean result = booleans[0] && booleans[1] || booleans[2] && booleans[3];
            System.out.println(i + ": " + result);
        }
    }
}
