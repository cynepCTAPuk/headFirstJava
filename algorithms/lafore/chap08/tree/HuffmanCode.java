package lafore.chap08.tree;

import java.util.*;

public class HuffmanCode {
    class Node implements Comparable<Node> {
        final int sum;
        String code;

        void builCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void builCode(String code) {
            super.builCode(code);
            left.builCode(code + "0");
            right.builCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void builCode(String code) {
            super.builCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        int count;
    }

    private void run() {
        String s = "SUSIE SAYS IT IS EASY";
//        String s ="abacabad";
        System.out.println(s);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { // fill
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 1);
        }

/*
        for (Character character : map.keySet()) {
            System.out.println("(" + character + "-" + map.get(character) + ") ");
        }
        System.out.println();
*/
        System.out.print("Sort by Value\t");
        map.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                forEach(result -> System.out.print(result + "\t"));
        System.out.println();

        System.out.print("Sort by Key  \t");
        map.entrySet().stream().
                sorted(Map.Entry.comparingByKey()).
                forEach(result -> System.out.print(result + "\t"));
        System.out.println();
/*
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
*/
/*
        System.out.println(map.keySet());
        System.out.println(map.values());
*/
        for (int i = 0; i < map.size(); i++) {
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.add(new LeafNode(entry.getKey(), entry.getValue()));
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        System.out.println(map.size() + " " + sum);
        Node root = priorityQueue.poll();
        root.builCode("");
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new HuffmanCode().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
