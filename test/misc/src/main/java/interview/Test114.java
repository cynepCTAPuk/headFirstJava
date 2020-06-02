package interview;

/**
 * Работа с числами
 * Необходимо реализовать функцию:
 * на вход функция получает целое число n;
 * значение числа n лежит в диапазоне (1000, 10000);
 * если значение сотни нечетное, умножить это число на два;
 * если значение сотни четное, добавить к этому числу 100;
 * полученное число вывести в консоль.
 * Sample Input 1:
 * 1111
 * Sample Output 1:
 * 2222
 * Sample Input 2:
 * 1211
 * Sample Output 2:
 * 1311
 */
public class Test114 {
    public static void main(String[] args) {
        calculateAndPrint(1111);
        calculateAndPrint(1211);
    }

    static void calculateAndPrint(int n) {
        if (n > 1000 && n < 10_000) {
            System.out.println(n / 100 % 2 == 0 ? n + 100 : n * 2);
        }
    }
}
