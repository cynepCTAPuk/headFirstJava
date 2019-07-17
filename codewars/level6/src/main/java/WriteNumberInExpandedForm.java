public class WriteNumberInExpandedForm {
    public static String expandedForm(int num) {
        String str = "";
        int i = 0;
        while (num > 0) {
            if (num % 10 != 0) str = " + " + num % 10 + "0".repeat(i) + str;
            num /= 10;
            i++;
        }
        return str.substring(3);
    }

    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(32));
        System.out.println(expandedForm(70304));
    }
}