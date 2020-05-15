package algorithms.stepik2;

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
 * aba<p>
 * abacaba<p>
 * Выход:<p>
 * 0 4<p>
 * "abcdefghijklmnoprqstuwxyz"
 */
public class Test323a {
    public static final int PRIME = 1_000_000_007;
    public static final int BASE = 263;

    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
*/
        String pattern = "aaaaaa";
        String text = "baaaaaaaaa";
        int p = pattern.length();
        int t = text.length();

        LinkedList<Integer> list = new LinkedList<>();
        long hashPattern = hash(pattern);
        long hash = hash(text.substring(t - p));
        long x = 1;
        for (int i = 1; i <= p - 1; i++) {
            x = x * BASE % PRIME;
        }
        x = x % PRIME;
        for (int i = t - p; i >= 0; i--) {
            if (i < t - p) {
                hash = (((hash - text.charAt(i + p) * x % PRIME) + PRIME) % PRIME
                                * BASE + text.charAt(i)) % PRIME;
            }
            if (hash == hashPattern && text.substring(i, i + p).equals(pattern)) {
                list.addFirst(i);
            }
            System.out.println(hash);
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static long hash(String string) {
        long hash = 0L;
        long x = 1L;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0) x = x * BASE % PRIME;
            hash = (hash + charArray[i] * x % PRIME) % PRIME;
        }
        hash %= PRIME;
        return hash;
    }
}
