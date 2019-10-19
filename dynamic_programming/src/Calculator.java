/**
 * https://tproger.ru/articles/dynprog-starters/
 * Калькулятор
 * Имеется калькулятор, который выполняет три операции:
 * Прибавить к числу X единицу;
 * Умножить число X на 2;
 * Умножить число X на 3.
 * Определите, какое наименьшее число операций необходимо для того,
 * чтобы получить из числа 1 заданное число N.
 * <p>
 * Выведите это число, и, на следующей строке, набор исполненных операций вида «111231».
 */
public class Calculator {
    public static void main(String[] args) {
        int n = 13;
        f(n);
    }

    public static void f(int n) {
        int[] array = new int[n + 1];
        array[1] = 0;
        int min;

        for (int i = 2; i < n + 1; i++) {
            min = array[i - 1] + 1;
            if (i % 2 == 0) min = Math.min(min, array[i / 2] + 1);
            if (i % 3 == 0) min = Math.min(min, array[i / 3] + 1);
            array[i] = min;
        }

        StringBuilder result = new StringBuilder();
        int i = n;

        while (i > 1) {
            if (array[i] == array[i - 1] + 1) {
                result.insert(0, 1);
                i--;
                continue;
            }
            if (i % 2 == 0 && array[i] == array[i / 2] + 1) {
                result.insert(0, 2);
                i /= 2;
                continue;
            }
            result.insert(0, 3);
            i /= 3;
        }
        System.out.print(array[n] + ":" + result);
    }
}
