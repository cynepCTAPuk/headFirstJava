package algorithms.stepik2;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Stepik Algorithm2: Хеширование цепочками<p>
 * Один из наиболее популярных методов реализации хеш-таблиц на практике. Ваша цель
 * в данной задаче - реализовать такую схему, используя таблицу с m ячейками и полиномиальной
 * хеш-функцией на строках.
 * Ваша программа должна поддерживать следующие типы запросов:
 * add string:
 * del string:
 * find string:
 * check i:
 * При добавлении строки в цепочку, строка должна добавляться в начало цепочки.<p>
 * Вход: Первая строка  размер хеш-таблицы m. Следующая строка содержит количество
 * запросов n. Каждая из последующих n строк содержит запрос одного из перечисленных
 * выше четырёх типов.<p>
 * Выход: Для каждого из запросов типа find и check выведите результат в отдельной строке.<p>
 * Ограничения: 1 <= n <= 10<sup>5</sup>; n/5 <= m <= n. Все строки имеют длину от одного до
 * пятнадцати и содержит только буквы латинского алфавита.<p>
 * Пример.<p>
 * Вход:<p>
 * 5<p>
 * 12<p>
 * add world<p>
 * add HellO<p>
 * check 4<p>
 * find World<p>
 * find world<p>
 * del world<p>
 * check 4<p>
 * del HellO<p>
 * add luck<p>
 * add GooD<p>
 * check 2<p>
 * del good<p>
 * Выход:<p>
 * HellO world<p>
 * no<p>
 * yes<p>
 * HellO<p>
 * GooD luck
 */
public class Test322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        LinkedList<String>[] table = new LinkedList[m];

        int n = Integer.parseInt(scanner.nextLine());
        String[] queries = new String[n];
        for (int i = 0; i < n; i++) queries[i] = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] input = queries[i].split(" ");
            String command = input[0];
            String string = input[1];
            switch (command) {
                case "add":
                    add(string, table);
                    break;
                case "find":
                    find(string, table);
                    break;
                case "del":
                    del(string, table);
                    break;
                case "check":
                    check(Integer.parseInt(string), table);
            }
        }
    }

    private static int index1(String string, int m) {
        int p = 1_000_000_007;
        long result = 0;
        char[] c = string.toCharArray();
        long x = 1;
        for (int i = 0; i < c.length; i++) {
            result += Math.abs((c[i] * x) % p);
            x *= 263;
            x %= p;
        }
        return (int) Math.abs((result % p) % m);
    }

    private static int index(String string, int m) {
        BigInteger primary = BigInteger.valueOf(1000000007);
        BigInteger x = BigInteger.valueOf(263);
        BigInteger tableSize = BigInteger.valueOf(m);
        BigInteger result = BigInteger.ZERO;
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            BigInteger ch = BigInteger.valueOf(charArray[i]);
            BigInteger pow = x.pow(i);
            result = result.add(pow.multiply(ch));
        }
        result = result.mod(primary);
        return result.mod(tableSize).intValue();
    }

    private static void add(String s, LinkedList<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            table[i] = new LinkedList<>();
        }
        if (table[i].contains(s)) {
            return;
        }
        table[i].addFirst(s);
    }

    private static void del(String s, List<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            return;
        }
        table[i].remove(s);
    }

    private static void find(String s, List<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            System.out.println("no");
            return;
        }
        System.out.println(table[i].contains(s) ? "yes" : "no");
    }

    private static void check(int i, List<String>[] table) {
        List<String> list = table[i];
        if (list != null) {
            for (String s : list) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }
}
