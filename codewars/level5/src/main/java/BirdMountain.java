import java.util.Arrays;

public class BirdMountain {

    public static int peakHeight(char[][] mountain) {
        int n = 1;
        for (int i = n; i < mountain.length; i++) {
            for (int j = n; j < mountain[0].length; j++) {
                if (i == n & mountain[i][j] == '^') mountain[i][j] = 'n';
                if (i == mountain.length - 1 & mountain[i][j] == '^') mountain[i][j] = '1';
                
            }
        }
        n++;

        return n;
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
        peakHeight(mountain);
        System.out.println(printChars(mountain));
    }
}