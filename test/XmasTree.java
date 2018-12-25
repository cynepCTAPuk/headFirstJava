public class XmasTree {
    public static void main(String[] args) {
        xmasTree1();
    }

    static void xmasTree1() {
        int i, j, k, r;
        int m = 1;
        int height = 3, width = 6;
        int space = width * 5;

        for (r = 1; r <= height; r++) {
            for (i = m; i <= width; i = i + 1) {
                for (j = space; j >= i; j--) System.out.print(" ");
                for (k = 1; k <= i; k++) System.out.print("# ");
                System.out.println();
            }
            m += width / 2;
            width += 6;
        }
        int branch = 4;
        for (i = 1; i <= branch; i++) {
            for (j = space - 3; j >= 1; j--) System.out.print(" ");
            for (k = 1; k <= 4; k++) System.out.print("| ");
            System.out.println();
        }
    }

    static void xmasTree2() {
        int i, j, k;
        int width = 10;
        for (i = 0; i < width; i++) {
            for (j = 0; j < 10 - i; j++) System.out.print(" ");
            for (k = 0; k < (2 * i + 1); k++) System.out.print("*");
            System.out.println();
        }
    }
}
