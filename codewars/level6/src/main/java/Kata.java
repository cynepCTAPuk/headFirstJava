public class Kata {
    public static String expandedForm(int num) {
        String result = String.valueOf(num);
        int[] ints = new int[result.length()];
        int i = 0;
        while (i < ints.length) {
            ints[i] = num % 10;
            num /= 10;
            i++;
        }
        for (int j = ints.length - 1; j >= 0; j--) {
            if (ints[j] != 0) {
                System.out.print(ints[j]);
                for (int k = 0; k < j; k++) {
                    System.out.print(0);
                }
                if (j > 0) System.out.print(" + ");
            }
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        expandedForm(12);
        expandedForm(32);
        expandedForm(70304);
    }
}