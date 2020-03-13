package integer;

public class IntegerToThree {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 9, 27, 81, 243, 729, 2187};
        int n = 1;
        for (int i = n; i <= n + 13; i++) {
            String s = Integer.toString(i, 3) + " ";
            System.out.format("%2d:%4s", i, s);

            int m = i;
            for (int j : ints) {
                if (i + i > j)
                    m += j;
            }

            s = Integer.toString(m, 3);
//            System.out.println(m+":"+s);
            s = s.replace('0', '-');
            s = s.replace('1', '0');
            s = s.replace('2', '+');
            System.out.format("%10s\t", s);
            char[] charArray = s.toCharArray();
            for (int j = charArray.length - 1; j >= 0; j--) {
                char c = charArray[j];
                if (c != '0') System.out.print(" " + c + " " + ints[charArray.length - j -1]);
            }
            System.out.println();
        }

    }
}
