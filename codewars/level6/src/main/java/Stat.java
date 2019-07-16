import java.util.Arrays;

public class Stat {

    public static String stat(String strg) {
        String result ="";
        String[] a1 = strg.split(", ");
        System.out.println(Arrays.toString(a1));
        int[] i1 = new int[a1.length];
        for (int i = 0; i < a1.length; i++) i1[i] = singleResultToSecond(a1[i]);
        Arrays.sort(i1);

        return result;
    }

    public static int singleResultToSecond(String string) {
        String[] arr = string.split("\\|");
        int result = 0;
        for (int i = 0; i < arr.length; i++) result += Integer.valueOf(arr[i]) * (arr.length - i);
        return result;
    }

    public static String range(int[] arr) {
        String result = "";
        int res = arr[arr.length] - arr[0];
        return res+"";
    }
    public static String average(int[] arr) {
        String result = "";
        int res = 0;
        for (int i = 0; i < arr.length; i++) res += arr[i];
        res = res / arr[arr.length];
        return res+"";
    }
    public static String median(int[] arr) {
        String result = "";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
    }
}
