import java.util.Arrays;

public class MexicanWave {
    public static String[] wave(String str) {
        String[] strings = new String[str.length()];
        int qty = 0;
        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toLowerCase().toCharArray();
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            } else continue;
            strings[qty] = String.valueOf(chars);
            qty++;
        }
        String[] result = new String[qty];
        for (int i = 0; i < qty; i++) {
            result[i] = strings[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("  (hello)  ")));
    }
}