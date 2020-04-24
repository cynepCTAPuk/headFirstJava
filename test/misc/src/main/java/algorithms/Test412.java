package algorithms;

import java.util.*;

/**
 * Stepik: Задача на программирование: непрерывный рюкзак
 * Первая строка содержит количество предметов 1 ≤ n ≤ 10E3 и вместимость рюкзака 0 ≤ W ≤ 2*10^6.
 * Каждая из следующих n строк задаёт стоимость 0 ≤ c<sub>i</sub> ≤ 2*10^6 и
 * объём 0 < w<sub>i</sub> ≤2*10^6 предмета (n, W, c<sub>i</sub>, w<sub>i</sub> — целые числа).
 * Выведите максимальную стоимость частей предметов
 * (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально
 * уменьшатся), помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 * <p>
 * Sample Input:<p>
 * 3 50<p>
 * 60 20<p>
 * 100 50<p>
 * 120 30<p>
 * Sample Output:<p>
 * 180.000
 */
public class Test412 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        long w = scanner.nextLong();
        List<Item> items = new ArrayList<>();
        while (scanner.hasNext()) {
            items.add(new Item(scanner.nextLong(), scanner.nextLong()));
        }
        Collections.sort(items);
//        System.out.println(items);
        long sum = 0;
        for (Item item : items) {
            long value = item.getValue();
            long volume = item.getVolume();
            if (volume <= w) {
                sum += value;
                w -= volume;
                if (w == 0) {
                    break;
                }
            } else {
                sum += w * value / volume;
                break;
            }
        }
//        Failed test #11 of 11. got: 1,232,250.998 expected: 1,232,251.0
        System.out.printf("%d.%03d%n", sum / 1_000, sum % 1_000);
    }

    private static class Item implements Comparable<Item> {
        private final long value;
        private final long volume;

        public Item(long value, long volume) {
            this.value = value * 1_000;
            this.volume = volume;
        }

        public long getValue() {
            return value;
        }

        public long getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "{value=" + value + ", volume=" + volume + '}';
        }

        @Override
        public int compareTo(Item o) {
            return (int) (o.getValue() / o.getVolume() - getValue() / getVolume());
        }
    }
}