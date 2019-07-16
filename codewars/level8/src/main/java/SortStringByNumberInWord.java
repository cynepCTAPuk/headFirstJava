import java.util.Arrays;

public class SortStringByNumberInWord {
    public static String order(String words) {
        String result = "";
        String[] list = words.split(" ");

        for (int i = 0; i < list.length; i++) {
            char first = 0;
            char[] chars = list[i].toCharArray();
            for (Character ch : chars) {
                int j = (int) ch;
                if (j >= 49 && j <= 57) {
                    first = ch;
                    break;
                }
            }
            list[i] = first + list[i];
        }
        Arrays.sort(list);

        for (String str : list) result = result + str.substring(1) + " ";
        return result.substring(0, result.length() - 1);
    }
}
