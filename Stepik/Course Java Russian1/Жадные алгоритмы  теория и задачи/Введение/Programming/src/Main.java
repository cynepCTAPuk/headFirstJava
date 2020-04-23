import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pair> pairs = new ArrayList<>();
        while (scanner.hasNext()) {
            pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(pairs);
//        System.out.println(n);
//        System.out.println(pairs);
        List<Integer> list = new ArrayList<>();
        int a = pairs.get(0).getB();
        list.add(a);
        for (Pair p : pairs) {
            if (!p.has(a)) {
                a = p.getB();
                list.add(a);
            }
        }
        System.out.println(list.size());
        list.forEach(x -> System.out.print(x + " "));
    }

}

class Pair implements Comparable<Pair> {
    private int a;
    private int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Pair o) {
        return b - o.b;
    }

    boolean has(int n) {
        return a <= n && n <= b;
    }

    @Override
    public String toString() {
        return "{a=" + a + ", b=" + b + '}';
    }
}
