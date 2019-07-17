public class Word_a10n_abbreviation {
    public static String abbreviate(String string) {
        String result = "";
        int i = 0;
        while (i < string.length()) {
            int n = 0;
            if (Character.isLetter(string.charAt(i))) {
                while (((i + n) < string.length()) && (Character.isLetter(string.charAt(i + n)))) {
                    n++;
                }
                if (n < 4) {
                    result += string.substring(i, i + n);
                } else {
                    result += string.substring(i, i + 1) + (n - 2) + string.substring(i + n - 1, i + n);
                }
            } else {
                n++;
                result += string.substring(i, i  + 1);
            }
            i = i + n;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(abbreviate("internationalization"));
        System.out.println(abbreviate("*= internationalization"));
        System.out.println(abbreviate("abc  internationalization"));
        System.out.println(abbreviate("abc"));
    }
}
