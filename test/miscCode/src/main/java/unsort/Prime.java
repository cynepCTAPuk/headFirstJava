package aaa;

public class Prime {
    public static void main(String[] args) {
        for (int i = 2; i < 27; i++) {
            System.out.println(i + "-" + trialDivision(i));
        }
    }

public static String trialDivision(int a) {
    String x = "Простое число";
    for (int i = 2; i * i <= a; i++) {
        if (a % i == 0) return "Составное число";
    }
    return x;
}
}
