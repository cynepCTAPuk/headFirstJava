public class WriteNumberInExpandedForm1 {
    public static String expandedForm(int num) {
        String original = String.valueOf(num);
        int size = original.length();
        StringBuilder result = new StringBuilder();
        String str = "";
        int[] ints = new int[size];
        int i = 0;
        while (i < size) {
            ints[i] = num % 10;
            num /= 10;
            i++;
        }
        for (int j = size - 1; j >= 0; j--) {
            if (ints[j] > 0) {
                result.append(ints[j]);
                result.append("0".repeat(j));
                if (j > 0) result.append(" + ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(32));
        System.out.println(expandedForm(70304));
    }
}