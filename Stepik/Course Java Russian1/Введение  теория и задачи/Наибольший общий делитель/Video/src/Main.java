// You can experiment here, it won’t be checked

class Task {
    public static int count = 0;
    public static final String FORMAT = "%,12d:%,12d%n";

    public static void main(String[] args) {
        int a = 3_918_848;
        int b = 1_653_264;
        a = (int) (Math.random() * 100_000_000);
        b = (int) (Math.random() * 100_000_000);
        System.out.printf(FORMAT, a, b);
        nod1(a, b);
        nod2(a, b);
        nod3(a, b);
    }

    private static void nod1(int a, int b) {
        int count = 1;
        if (a == 0 || b == 0) {
            System.out.printf(FORMAT, 0, count);
            return;
        }
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.printf(FORMAT, i, count);
                return;
            }
            count++;
        }
        System.out.printf(FORMAT, 0, count);
    }

    private static void nod2(int a, int b) {
        int count = 1;
        if (a == 0 || b == 0) {
            System.out.printf(FORMAT, 0, count);
            return;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int c;
        while (max - min > 0) {
            c = max - min;
            max = Math.max(c, min);
            min = Math.min(c, min);
            if (max % min == 0) {
                System.out.printf(FORMAT, min, count);
                return;
            }
            count++;
        }
    }

    private static void nod3(int a, int b) {
        count++;
        if (a == 0) {
            System.out.printf(FORMAT, b, count);
            return;
        }
        if (b == 0) {
            System.out.printf(FORMAT, a, count);
            return;
        }
        if (a >= b) nod3(a % b, b);
        if (b >= a) nod3(a, b % a);
    }
}
