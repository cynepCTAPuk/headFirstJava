import java.util.Arrays;

public class StatisticsForAthleticAssociation {

    public static String stat(String strg) {
        String[] strings = strg.split(", ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) ints[i] = singleResultToSecond(strings[i]);
        Arrays.sort(ints);
        return range(ints) + " " + average(ints) + " " + median(ints);
    }

    public static int singleResultToSecond(String string) {
        String[] arr = string.split("\\|");
        int result = 0;
        for (int i = 0; i < arr.length; i++)
            result += Math.pow(60, arr.length - i - 1) * Integer.valueOf(arr[i]);
        return result;
    }

    public static String resultToString(int res) {
        int seconds = res % 60;
        int minutes = res / 60 % 60;
        int hours = res / 3600 % 60;
        return String.format(" %02d|%02d|%02d", hours, minutes, seconds);
    }

    public static String range(int[] arr) {
        int result = arr[arr.length - 1] - arr[0];
        return "Range:" + resultToString(result);
    }

    public static String average(int[] arr) {
        int result = 0;
        for (int value : arr) result += value;
        result = result / arr.length;
        return "Average:" + resultToString(result);
    }

    public static String median(int[] arr) {
        int size = arr.length;
        int result = 0;
        if (size % 2 == 1) result = arr[size/2];
        if (size % 2 == 0) result = (arr[size/2 - 1] + arr[size/2]) / 2;
        return "Median:" + resultToString(result);
    }
}
