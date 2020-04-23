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
        int n = scanner.nextInt();
        double w = scanner.nextDouble();

        List<Item> items = new ArrayList<>();
        while (scanner.hasNext()) {
            items.add(new Item(scanner.nextDouble(), scanner.nextDouble()));
        }
//        System.out.println(goods);
        Collections.sort(items);
//        System.out.println(n);
//        System.out.println(goods);
//        Failed test #11 of 11. got: 1232250.998 expected: 1232251.0
        double sum = 0;
        for (Item item : items) {
            double value = item.getValue();
            double volume = item.getVolume();
            if (w > volume) {
                sum += value;
                w -= volume;
            } else {
                sum += w * value / volume;
                break;
            }
        }
        System.out.printf("%.3f%n", sum);
    }

    private static class Item implements Comparable<Item> {
        private final double value;
        private final double volume;

        public Item(double value, double volume) {
            this.value = value;
            this.volume = volume;
        }

        public double getValue() {
            return value;
        }

        public double getVolume() {
            return volume;
        }

        @Override
        public String toString() {
            return "{value=" + value + ", volume=" + volume + '}';
        }

        @Override
        public int compareTo(Item o) {
            return (int) (1000 * (o.getValue() / o.getVolume() - getValue() / getVolume()));
        }
    }
}