// You can experiment here, it won’t be checked

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class Task {
    public static void main(String[] args) {
/*
        int n = 5;
        System.out.println(factorial(n));
*/
/*
        int[] arr1 = {0, 2, 2, 4, 5, 6};
        int[] arr2 = {1, 2, 2, 3};
        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
*/
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич",};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        System.out.println(printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        String separator = System.lineSeparator();
        for (String role : roles) {
            result.append(role).append(':').append(separator);
            for (int i = 0; i < textLines.length; i++) {
                String text = textLines[i];
                int index = text.indexOf(':');
                if (text.substring(0, index).equals(role)) {
                    result.append(i + 1).append(")").append(text.substring(index + 1)).append(separator);
                }
            }
            result.append(separator);
        }
        return result.toString();
    }

    private static String printTextPerRole1(String[] roles, String[] textLines) {
        String result = "";
        Map<String, String> map = new LinkedHashMap<>();
        int i = 1;
        for (String s : textLines) {
            int index = s.indexOf(':');
            String role = s.substring(0, index + 1);
            String text = s.substring(index + 1);
            if (!map.containsKey(role)) {
                map.put(role, i++ + ")" + text + "\n");
            } else {
                map.put(role, map.get(role) + i++ + ")" + text + "\n");
            }
        }
        for (String s : map.keySet()) {
            result += s + "\n" + map.get(s) + "\n";
        }
        return result;
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        if (value < 0) return null;
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(i + ""));
        }
        return bigInteger;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (idx1 < a1.length && idx2 < a2.length) {
                if (a1[idx1] <= a2[idx2]) result[i] = a1[idx1++];
                else result[i] = a2[idx2++];
            } else if (idx1 < a1.length) {
                result[i] = a1[idx1++];
            } else result[i] = a2[idx2++];
        }
        return result;
    }

    public static int[] mergeArrays1(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (a1[idx1] <= a2[idx2]) {
                result[i] = a1[idx1++];
                if (idx1 == a1.length) {
                    int k = i + 1;
                    for (int j = k; j < result.length; j++) {
                        result[++i] = a2[idx2++];
                    }
                }
            } else {
                result[i] = a2[idx2++];
                if (idx2 == a2.length) {
                    int k = i + 1;
                    for (int j = k; j < result.length; j++) {
                        result[++i] = a1[idx1++];
                    }
                }
            }
        }
        return result;
    }
}
