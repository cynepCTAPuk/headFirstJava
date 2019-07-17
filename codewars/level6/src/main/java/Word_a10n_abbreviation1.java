public class Word_a10n_abbreviation1 {
    private static String abbreviate(String s) {
        String[] words = s.split("[^a-zA-Z]+");
        String[] separators = s.split("[a-zA-Z]+");
        String result = "";

        int i = 1;
        for (String word : words) {
            result += processWord(word);
            if (i < separators.length) {
                result += separators[i++];
            }
        }
        return result;
    }

    private static String processWord(String word) {
        if (word.length() < 4) return word;
        int n = word.length() - 2;
        return "" + word.charAt(0) + n + word.charAt(word.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(abbreviate("internationalization"));
        System.out.println(abbreviate("*= internationalization"));
        System.out.println(abbreviate("abc  internationalization"));
        System.out.println(abbreviate("abc"));
    }
}
