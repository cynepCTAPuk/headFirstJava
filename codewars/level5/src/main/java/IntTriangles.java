public class IntTriangles {
    public static int giveTriang(int per) {
        int result = 0;
        for (int c = 0; c <= per; c++) {
            for (int a = 0; a < per; a++) {
                for (int b = 0; b < per; b++) {
                    if (c * c == (a * a + b * b + a * b)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(giveTriang(5));
        System.out.println(giveTriang(15));
        System.out.println(giveTriang(30));
        System.out.println(giveTriang(50));
    }
}
