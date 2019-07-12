import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Order1 {
    public static String order(String words) {
        String result = "";
        System.out.println(words);
        List<String> list = Arrays.asList(words.split(" "));

        for (int i = 0; i < list.size(); i++) {
            char first = 0;
            char[] chars = list.get(i).toCharArray();
            for (Character ch : chars) {
                int j = (int) ch;
                if (j >= 49 && j <= 57) first = ch;
            }
            list.set(i, first + list.get(i));
        }
        Collections.sort(list);

        for (String str : list) result = result + str.substring(1) + " ";
        return result.substring(0, result.length() - 1);

    }
}
