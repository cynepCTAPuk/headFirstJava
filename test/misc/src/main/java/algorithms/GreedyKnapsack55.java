package algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Stepik: Задача на программирование: непрерывный рюкзак (5.5)
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
public class GreedyKnapsack55 {
    class Item implements Comparable<Item> {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public int compareTo(Item o) {
/*
            double r1 = (double) this.cost / this.weight;
            double r2 = (double) o.cost / o.weight;
            return -Double.compare(r1, r2);
*/
            long r1 = (long) this.cost * o.weight;
            long r2 = (long) o.cost * this.weight;
            return -Long.compare(r1, r2);
//            return (int) (r2-r1);

        }

        @Override
        public String toString() {
            return "Item{" + "cost=" + cost + ", weigth=" + weight + '}';
        }
    }

    private void run() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("c:/000/GreedyKnapsack.txt"));
        int n = scanner.nextInt();
        int W = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        for (int i = 0; i < n; i++) System.out.println(items[i]);
/*
        Arrays.sort(items, (o1, o2) -> {
            double r1 = (double) o1.cost / o1.weight;
            double r2 = (double) o2.cost / o2.weight;
            return -Double.compare(r1, r2);
        });
*/
        Arrays.sort(items);
//        for (int i = 0; i < n; i++) System.out.println(items[i]);
        double result = 0;
        for (Item item : items) {
            if (item.weight <= W) {
                result += item.cost;
                W -= item.weight;
            } else {
                result += (double) item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new GreedyKnapsack55().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
    }
}