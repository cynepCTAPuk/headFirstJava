import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
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
                sum += w / volume * value;
                break;
            }
        }
//        Failed test #11 of 11. got: 1,232,250.998 expected: 1,232,251.0
        System.out.printf("%d.%03d%n", sum / 1000, sum % 1000);
    }

    private static class Item implements Comparable<Item> {
        private final long value;
        private final long volume;

        public Item(long value, long volume) {
            this.value = value * 1000;
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