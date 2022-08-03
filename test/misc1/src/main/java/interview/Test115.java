package interview;

/**
 * Работа с массивом
 * Необходимо реализовать функцию:
 * на вход функция получает массив целых чисел;
 * нужно определить максимальную длину подмассива, у которого все элементы возрастают,  A_{i} \leq A_{i+1}A
 * i
 *  ≤A
 * i+1
 *  ;
 * вычисленную длину вывести в консоль.
 * Sample Input:
 * 2 1 4 1 2 3 4 5 6 7 3 1
 * Sample Output:
 * 7
 */
public class Test115 {
    public static void main(String[] args) {
        int[] array = {2, 1, 4, 1, 2, 3, 4, 5, 6, 7, 3, 1};
//        int[] array = new int[0];
        checkSortArrayLength(array);
    }

    static void checkSortArrayLength(int[] a) {
    int size = a.length;
    int[] d = new int[size];
    for (int i = 0; i < size; i++) {
        d[i] = 1;
        for (int j = 0; j < i; j++)
            if (a[i] >= a[j])
                d[i] = Math.max(d[j] + 1, d[i]);
    }
    int max = 0;
    for (int i : d) if (max < i) max = i;
    System.out.println(max);

        for (int i : a) System.out.printf("%2d ", i);
        System.out.println();
        for (int i : d) System.out.printf("%2d ", i);
    }
}
