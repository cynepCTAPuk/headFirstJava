package chap04;

public class PrimeNumbers {
    static int[] primeNumbers;

    public static void main(String[] args) {
        int n = 1_000;
        long t0 = System.nanoTime();
        printPrimeNumbers(n);
        long t1 = System.nanoTime();
        System.out.format("Time seeking: %,d", (t1 - t0));
    }

    static int printPrimeNumbers(int numbers) {   // Основная функция
        // Массив найденных простых чисел
        int primes = numbers / 2;
        primeNumbers = new int[primes];

        int i; // номер проверяемого числа - делителя
        int k; // количество найденных простых чисел
        int n; // очередное проверяемое число
        k = 0;

        for (n = 2; n < numbers; n++) { // Проверяем на простоту все числа
            for (i = 0; i < k; i++) { // Делим на все уже найденные простые числа
                // Если поделилось - не простое
                if ((n % primeNumbers[i]) == 0) break;
            }
            /* Если предыдущий цикл нормально закончился - значит, ни на что
             * не поделилось - простое - добавляем в массив */
            if (i == k) primeNumbers[k++] = n;
        }
        /* Выводим все найденные числа */
        System.out.printf("Простые числа, не превосходящие %,d\n", numbers);
        for (i = 0; i < k; i++) System.out.printf("%,d ", primeNumbers[i]);
        System.out.printf("\nКол-во простых чисел: %d\n", k);

        return k;
    } /* End of 'printPrimeNumbers' function */
}
