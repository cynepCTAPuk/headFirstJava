package algorithms.stepik2;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Stepik Algorithm2: Поиск образца в тексте<p>
 * Найти все вхождения строки Pattern в строку Text.<p>
 * Реализуйте алгоритм Карпа-Рабина<p>
 * Вход: Строки Pattern и Text.<p>
 * Выход: Все индексы i строки Text, начиная с которых строка Pattern входит в Text:
 * Text[i...i + |Pattern| - 1] = Pattern.<p>
 * Ограничения: 1 <= |Pattern| <= |Text| <= 5*10<sup>5</sup>.<p>
 * Суммарная длина всех вхождений образца в текст не превосходит 10<sup>8</sup>.
 * Обе стороны содержат буквы латинского алфавита.<p>
 * Пример.<p>
 * Вход:<p>
 * aba
 * abacaba
 * Выход:<p>
 * o 4
 * "abcdefghijklmnoprqstuwxyz"
 */
public class Test323 {
    public static final int PRIME = 1_000_000_007;

    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
*/
        String pattern = "aaaaaaaaaaaaaaaaa";
        String text = "baaaaaaaaaaaaaaaaaaa";
        int p = pattern.length();
        int t = text.length();

        long hashPattern = hash(pattern);
        long hash = hash(text.substring(t - p));
        LinkedList<Integer> list = new LinkedList<>();
        long x = BigInteger.valueOf(263)
                         .modPow(BigInteger.valueOf(p - 1), BigInteger.valueOf(PRIME))
                         .longValue();
        for (int i = t - p; i >= 0; i--) {
            if (i < t - p) {
                hash = ((hash + PRIME - ((text.charAt(i + p) * x) % PRIME)) * 263 + text.charAt(i))
                               % PRIME;
            }
            if (hash == hashPattern && text.substring(i, i + p).equals(pattern)) {
                list.addFirst(i);
            }
//            System.out.println(hash);
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static long hash(String string) {
        long hash = 0L;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            long x = BigInteger.valueOf(263)
                             .modPow(BigInteger.valueOf(i), BigInteger.valueOf(PRIME))
                             .longValue();
            hash += charArray[i] * x;
        }
        hash %= PRIME;
        return hash;
    }
}
