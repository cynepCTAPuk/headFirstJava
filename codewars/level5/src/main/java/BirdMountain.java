public class BirdMountain {
    private static char[][] chars;

    public static int peakHeight(char[][] mountain) {
        chars = mountain;
        int count = 0;
        int prev = 0;
        int n = 0;
        char d = '1';
        while (true) {
            for (int i = 0; i < chars.length; i++)
                for (int j = 0; j < chars[0].length; j++)
                    if (isTouch(i, j, d)) {
                        count++;
                        chars[i][j] = d;
                    }
            if (count == prev) break;
            else prev = count;
            n++;
            d++;
        }
        return n;
    }

    public static boolean isTouch(int i, int j, char d) {
        char curr = chars[i][j];
        if (i == 0 | j == 0 | i == chars.length - 1 | j == chars[0].length - 1) return curr == '^';
        char left = chars[i][j - 1];
        char right = chars[i][j + 1];
        char top = chars[i - 1][j];
        char bottom = chars[i + 1][j];
        return (left < d | top < d | bottom < d | right < d) && curr == '^';
    }

    public static String printChars(char[][] chars) {
        String string = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                string += chars[i][j];
                string += j < chars[0].length - 1 ? "" : "\n";
            }
        }
        return string;
    }

    public static void main(String[] args) {
        char[][] mountain = {
                "^^^^^^        ".toCharArray(),
                " ^^^^^^^^     ".toCharArray(),
                "  ^^^^^^^     ".toCharArray(),
                "  ^^^^^       ".toCharArray(),
                "  ^^^^^^^^^^^ ".toCharArray(),
                "  ^^^^^^      ".toCharArray(),
                "  ^^^^        ".toCharArray()
        };
        System.out.println(peakHeight(mountain));
        System.out.println(printChars(mountain));
//        System.out.println((int) ' ' + " " + (int) '^' + " " + (int) '1' + " " + ('1' + 1));
    }
}