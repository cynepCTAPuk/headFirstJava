public class ReverseWords2 {
    public static String reverseWords(final String original) {
        String[] strings = original.split(" ");
        String result = "";
        for (String word : strings) result += reverse(word) + " ";
        return result.substring(0, result.length() - 1);
    }

    public static String reverse(String word) {
        char[] chars = word.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) newChars[i] = chars[chars.length - (i + 1)];
        return new String(newChars);
    }
}