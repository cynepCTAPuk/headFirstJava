package logical;

public class OrderLogicalOps {
    public static void main(String[] args) {
        boolean[] b = new boolean[4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < b.length; j++) {
                b[j] = !(Math.random() < 0.5);
            }
            for(boolean bool: b) System.out.print(bool + " ");
            System.out.println();
            boolean result = b[0] && b[1] || b[2] && b[3];
            System.out.println(i + ": " + result);
        }
        calc();
    }

    public static void calc() {
        System.out.println("Hello Andrey");
    }
}
