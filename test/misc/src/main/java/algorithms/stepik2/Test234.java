package algorithms.stepik2;

import java.util.Scanner;

/**
 * Stepik Algorithm2: Автоматический анализ программ<p>
 * Проверить, можно ли присвоить переменным целые значения, чтобы выполнить заданные равенства
 * вида x<sub>i</sub> = x<sub>j</sub> и неравенства вида x<sub>p</sub> != x<sub>q</sub>.<p>
 * Вход: Первая строка содержит числа n, e, d. Каждая из следующих e строк содержит
 * два числа i и j и задаёт равенство x<sub>i</sub> = x<sub>j</sub>. Каждая из следующих d
 * строк содержит два числа i и j и задаёт неравенство x<sub>i</sub> != x<sub>j</sub>.
 * Переменные индексируются с 1: x<sub>1</sub>, ..., x<sub>n</sub>.<p>
 * Выход: Выведите 1, если переменным x<sub>1</sub>, ..., x<sub>n</sub>, можно присвоить
 * целые значения, чтобы все равенства и неравенства выполнились. В противном случае
 * выведите 0.<p>
 * Ограничения: 1 <= 10<sup>5</sup>; 0 <= e,d; e + d <= 2*10<sup>5</sup>; 1 <= i, j <= n<p>
 * Пример.<p>
 * Вход:<p>
 * 6 5 3<p>
 * 2 3<p>
 * 1 5 <p>
 * 2 5<p>
 * 3 4<p>
 * 4 2<p>
 * 6 1<p>
 * 4 6<p>
 * 4 5<p>
 * Выход:<p>
 * 0
 */
public class Test234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // qty numbers
        int[] number = new int[n];
        int e = scanner.nextInt();  // qty equal
        int d = scanner.nextInt();  // qty notequal

        int[] leftN = new int[e + d];
        int[] rightN = new int[e + d];
        for (int i = 0; i < e + d; i++) {
            leftN[i] = scanner.nextInt() - 1;
            rightN[i] = scanner.nextInt() - 1;
        }

        int result = 1;
        for (int i = 0; i < e + d; i++) {
            int left = leftN[i];
            int right = rightN[i];
            if (i < e) {
                if (number[left] == 0 && number[right] == 0) {
                    number[left] = i;
                    number[right] = i;
                } else if (number[left] == 0) {
                    number[left] = number[right];
                } else if (number[right] == 0) {
                    number[right] = number[left];
                }
                if (number[left] != number[right]) {
                    result = 0;
                    break;
                }
            } else {
                if (number[left] == number[right]) {
                    result = 0;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
