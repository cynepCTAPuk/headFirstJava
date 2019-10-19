/**
 * https://tproger.ru/articles/dynprog-starters/
 * Вычислить n-й член последовательности, заданной формулами:
 * a(2n) = a(n) + a(n-1),
 * a(2n+1) = a(n) – a(n-1),
 * a(0) = a(1) = 1.
 */
public class OddEven1 {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) System.out.print(i + ":" + OddEven.f(i) + " ");
        System.out.println();
        for (int i = 0; i < n; i++) System.out.print(i + ":" + OddEven.fcashe(i) + " ");
        System.out.println();
        for (int i = 0; i < n; i++) System.out.print(i + ":" + f(i) + " ");
    }

    public static int f(int n) {
        if (n < 2) return 1; //Может, нам и вычислять ничего не нужно?
        int[] array = new int[n + 1]; //Создаём массив для значений
        array[0] = array[1] = 1; //Задаём начальные состояния

        for (int i = 2; i < n + 1; i++) {
            //Проверяем чёт/нечёт
            if (i % 2 == 0)
                array[i] = array[i / 2] + array[i / 2 - 1];
            else
                array[i] = array[(i - 1) / 2] - array[(i - 1) / 2 - 1];
        }

        return array[n];
    }
}
