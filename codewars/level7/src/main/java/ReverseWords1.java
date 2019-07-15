public class ReverseWords1 {
    static String reverseWords(final String original) {
        char[] chars = original.toCharArray();
        if (chars.length == 0) return original;

        String result = "";
        int i = 0;
        do {
            if (chars[i] == ' ') {
                result += ' ';
                i++;
            } else {
                String word = "";
                while ((chars[i] != ' ')) {
                    word += chars[i++];
                    if (i == chars.length) break;
                }
                result += reverse(word);
            }
        } while (i != chars.length);
        return result;
    }

    static String reverse(String word) {
        char[] chars = word.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) newChars[i] = chars[chars.length - (i + 1)];
        return new String(newChars);
    }
}