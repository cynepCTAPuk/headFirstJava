/**
 * https://tproger.ru/articles/dynprog-starters/
 * Подъём по лестнице
 * Мальчик подошел к платной лестнице.
 * Чтобы наступить на любую ступеньку, нужно заплатить указанную на ней сумму.
 * Мальчик умеет перешагивать на следующую ступеньку, либо перепрыгивать через ступеньку.
 * <p>
 * Требуется узнать, какая наименьшая сумма понадобится мальчику, чтобы добраться до верхней ступеньки.
 */
public class TollStaircase {
    public static void main(String[] args) {
        int n = 2;
    }

    static void f(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            ///Ввод с клавиатуры стоимости ступеньки array[i]
        }

        for (int i = 2; i < array.length; i++) {
            array[i] += Math.min(array[i - 1], array[i - 2]);
        }

        System.out.println(array[n - 1]);
    }
}
