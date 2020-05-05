package algorithms.stepik1;

import java.util.*;

/**
 * Stepik Algorithm1: Задача на программирование: покрыть отрезки точками
 * По данным n отрезкам необходимо найти множество точек минимального размера,
 * для которого каждый из отрезков содержит хотя бы одну из точек.
 * <p>
 * В первой строке дано число 1 ≤ n ≤ 100 отрезков. Каждая из последующих
 * n строк содержит по два числа 0 ≤ l ≤ r ≤10E9, задающих начало и конец отрезка.
 * Выведите оптимальное число m точек и сами m точек. Если таких множеств точек
 * несколько, выведите любое из них.
 * <p>
 * Sample Input 1:<p>
 * 3<p>
 * 1 3<p>
 * 2 5<p>
 * 3 6<p>
 * Sample Output 1:<p>
 * 1<p>
 * 3<p>
 * Sample Input 2:<p>
 * 4<p>
 * 4 7<p>
 * 1 3<p>
 * 2 5<p>
 * 5 6<p>
 * Sample Output 2:<p>
 * 2<p>
 * 3 6<p>
 */
public class Test411 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Segment> segments = new ArrayList<>();
        int n = scanner.nextInt();
        while (scanner.hasNext()) {
            segments.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }
        segments.sort((o1, o2) -> o1.getEnd() - o2.getEnd());
        System.out.println(segments);
        List<Integer> list = new ArrayList<>();
        int a = segments.get(0).getEnd();
        list.add(a);
        for (Segment p : segments) {
            if (!p.has(a)) {
                a = p.getEnd();
                list.add(a);
            }
        }
        System.out.println(list.size());
        list.forEach(x -> System.out.print(x + " "));
    }

    private static class Segment{
        private int begin;
        private int end;

        public Segment(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public int getBegin() {
            return begin;
        }

        public int getEnd() {
            return end;
        }

        boolean has(int n) {
            return begin <= n && n <= end;
        }

        @Override
        public String toString() {
            return "{a=" + begin + ", b=" + end + '}';
        }
    }
}

