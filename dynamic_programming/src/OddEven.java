import java.util.HashMap;

/**
 * https://tproger.ru/articles/dynprog-starters/
 * Вычислить n-й член последовательности, заданной формулами:
 * a(2n) = a(n) + a(n-1),
 * a(2n+1) = a(n) – a(n-1),
 * a(0) = a(1) = 1.
 */
public class OddEven {
    public static void main(String[] args) {
        int n = 9_999_999;
        long t0;
        t0 = System.nanoTime();
        System.out.println(f(n));
        System.out.printf("%,d\n",System.nanoTime()-t0);

        t0 = System.nanoTime();
        System.out.println();
        System.out.println(fcashe(n));
        System.out.printf("%,d\n",System.nanoTime()-t0);

        t0 = System.nanoTime();
        System.out.println();
        System.out.println(OddEven1.f(n));
        System.out.printf("%,d\n",System.nanoTime()-t0);
    }

    public static int f(int n) {
        if (n == 0 || n == 1) return 1; // Проверка на начальное значение

        if (n % 2 == 0) { //Проверка на чётность
            return f(n / 2) + f(n / 2 - 1); // Вычисляем по формуле для чётных индексов,
            //  ссылаясь на предыдущие значения
        } else {
            return f((n - 1) / 2) - f((n - 1) / 2 - 1);  // Вычисляем по формуле для нечётных
            //индексов, ссылаясь на предыдущие значения
        }
    }

    private static HashMap<Integer, Integer> cache = new HashMap<>();

    public static int fcashe(int n) {
        if (!cache.containsKey(n)) {//Проверяем, находили ли мы данное значение
            cache.put(n, f(n)); //Если нет, то находим и записываем в таблицу
        }
        return cache.get(n);
    }
}
