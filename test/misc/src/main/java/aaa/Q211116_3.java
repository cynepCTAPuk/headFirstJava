package aaa;

public class Q211116_3 {

    public static void main(String[] args) {
        String s = " true ";
        boolean b = Boolean.parseBoolean(s);
        System.out.println(b);

        System.out.println(padLeftZeros("111", 10));
        System.out.println(padLeftZeros1("11", 10));
        System.out.println(padLeftZeros2("1", 10));
    }

    static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) return inputString;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) sb.append('0');
        sb.append(inputString);
        return sb.toString();
    }

    static String padLeftZeros1(String inputString, int length) {
        if (inputString.length() >= length) return inputString;
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(length));
        return sb.substring(inputString.length()) + inputString;
    }

    static String padLeftZeros2(String inputString, int length) {
        return String.format("%1$" + length + "s", inputString).replace(' ', '0');
    }
}

