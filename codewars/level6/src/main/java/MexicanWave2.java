import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MexicanWave2 {
    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toLowerCase().toCharArray();
            if (chars[i] >= 'a' && chars[i] <= 'z') chars[i] = (char) (chars[i] - 32);
            else continue;
            list.add(String.valueOf(chars));
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) result[i] = list.get(i);
        return result;
//        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("  (hello)  ")));
    }
}