package algorithms.stepik1;

import java.util.*;

/**
 * Stepik: кодирование Хаффмана
 * По данной непустой строке ss длины не более 10^4, состоящей из строчных букв
 * латинского алфавита, постройте оптимальный беспрефиксный код.
 * В первой строке выведите количество различных букв kk, встречающихся в строке,
 * и размер получившейся закодированной строки. В следующих kk строках запишите коды букв
 * в формате "letter: code". В последней строке выведите закодированную строку.<p>
 * Sample Input 1:<p>
 * a<p>
 * Sample Output 1:<p>
 * 1 1<p>
 * a: 0<p>
 * 0<p>
 * Sample Input 2:<p>
 * abacabad<p>
 * Sample Output 2:<p>
 * 4 14<p>
 * a: 0<p>
 * b: 10<p>
 * c: 110<p>
 * d: 111<p>
 * 01001100100111
 */
public class Test421 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        String input = "abacabad";
        String input = "characternodemap";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        Map<Character, Node> characterNodeMap = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Leaf node = new Leaf(entry.getKey(), entry.getValue());
            characterNodeMap.put(entry.getKey(), node);
            priorityQueue.add(node);
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            Tree tree = new Tree(first, second);
            sum += tree.freq;
            priorityQueue.add(tree);
        }

        if (map.size() == 1) sum = input.length();

        Node root = priorityQueue.poll();
        root.buildCode(map.size() == 1 ? "0" : "");


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stringBuilder.append(characterNodeMap.get(c).code);
        }

        System.out.println(characterNodeMap.size() + " " + sum);
        characterNodeMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o1.getValue().code.compareTo(o2.getValue().code))
                .forEach(a -> System.out.println(a.getKey() + ":" + a.getValue().code));
        System.out.println(stringBuilder);
    }

    private static class Node implements Comparable<Node> {
        final int freq;
        String code;

        public Node(int freq) {
            this.freq = freq;
        }

        void buildCode(String code) {
            this.code = code;
        }

        @Override
        public int compareTo(Node o) {
            return freq - o.freq;
        }

        @Override
        public String toString() {
            return "{freq=" + freq + ", code=" + code + '}';
        }
    }

    private static class Tree extends Node {
        Node left;
        Node right;

        public Tree(Node left, Node right) {
            super(left.freq + right.freq);
            this.left = left;
            this.right = right;
        }

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }
    }

    private static class Leaf extends Node {
        char symbol;

        public Leaf(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }
}