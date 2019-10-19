/**
 * https://tproger.ru/articles/dynprog-starters/
 * Взрывоопасность
 * При переработке радиоактивных материалов образуются отходы двух видов
 * — особо опасные (тип A) и неопасные (тип B).
 * Для их хранения используются одинаковые контейнеры.
 * После помещения отходов в контейнеры последние укладываются вертикальной стопкой.
 * Стопка считается взрывоопасной, если в ней подряд идет более одного контейнера типа A.
 * Стопка считается безопасной, если она не является взрывоопасной.
 * <p>
 * Для заданного количества контейнеров N определить количество возможных типов безопасных стопок.
 *
 * Ответом является (N+1)-е число Фибоначчи. Догадаться можно было, посмотрев на 3 первых значения.
 * 2-3-5
 * Строго доказать можно было, построив дерево возможных построений.
 */
public class ExplosionStack {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 1; i < n; i++) {
            System.out.println(f(i));
        }
    }

    static int f(int n) {
        n += 2;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 2; i < n; i++)
            array[i % 2] = array[0] + array[1];
        return array[(n - 1) % 2];
    }
}
