package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class StringConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
//        boolean isNumeric = s.chars().allMatch(Character::isDigit);
        while (!s.equals("exit")) {
            if (isDouble(s)) {
                double d = Double.parseDouble(s);
                if (s.contains(".")) print(d);
                else if (d < 128 && d > 0) print((short) d);
                else print((int) d);
            } else print(s);

            s = bufferedReader.readLine();
        }
    }

    public static boolean isDouble(String s) {
        if (s == null) return false;
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumber(String s) {
        if (s == null) return false;
        return pattern.matcher(s).matches();
    }

    public static boolean isPositiveInteger(String s) {
        for (char c : s.toCharArray())
            if (!Character.isDigit(c)) return false;
        return true;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
