public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        char[] chars = word.toCharArray();
        char[] bracket = new char[word.length()];
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (j != i && chars[j] == chars[i]) {
                    count++;
                    break;
                }
            }
            bracket[i] = count > 0 ? ')' : '(';
        }
        return String.valueOf(bracket);
    }
}
