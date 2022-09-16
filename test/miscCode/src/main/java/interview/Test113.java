package interview;

/**
 * Числа Фибоначчи
 *  Это числовой ряд, который выглядит следующим образом:
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 * A0 = 0
 * A1 = 1
 * An+1 = An + An-1
 * Необходимо реализовать функцию:
 * на вход функция получает целое число n;
 * необходимо вывести в консоль значение числа Фибоначчи под номером n;
 * не рекомендуется использовать рекурсию.
 * Sample Input 1:
 * 6
 * Sample Output 1:
 * 8
 * Sample Input 2:
 * 11
 * Sample Output 2:
 * 89
 */
public class Test113 {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            printFibonacci(i);
            System.out.print(" ");
        }
    }

    static void printFibonacci(long n) {
        long a = 0;
        long b = 1;
        long c = 0;
        for (long i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.print(a);
    }
}
