package unsort;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 1111;
        PrimeNumber primeNumber = new PrimeNumber();
        int m = primeNumber.getPrime(n);
        System.out.format("First Prime after %d = %d", n, m);
    }

    private int getPrime(int min) { // Возвращает первое простое число > min
        int newmin = min + 1;
        if (newmin % 2 == 0) newmin++;
        for (int i = newmin; true; i = i + 2) {  // Для всех i > min
            System.out.format("%4d = ", i);
            if (isPrime(i)) {               // Число i простое?
                return i;                   // Да, вернуть его
            }
        }
    }

    // -------------------------------------------------------------
    private boolean isPrime(int n) {        // Число n простое?
        for (int i = 2; i * i <= n; i++) {  // Для всех i
            System.out.format("%d ", i);
            if (n % i == 0) {               // Делится на i без остатка?
                System.out.println();
                return false;               // Да, число не простое
            }
        }
        System.out.println();
        return true;                        // Нет, число простое
    }
}
