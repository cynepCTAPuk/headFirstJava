public class IntTriangles {
    public static int giveTriang(int per) {
        int result = 0;
        for (int a = 1; a <= (per - 2); a++)
            for (int b = a; b <= (per - a); b++)
                for (int c = b; c <= (per - (a + b)); c++)
                    if (c * c == (a * a + b * b + a * b))
                        result++;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(" 5 --- " + giveTriang(5));
        System.out.println("15 --- " + giveTriang(15));
        System.out.println("30 --- " + giveTriang(30));
        System.out.println("50 --- " + giveTriang(50));
    }
}
