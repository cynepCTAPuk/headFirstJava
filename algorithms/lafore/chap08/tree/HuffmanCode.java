package lafore.chap08.tree;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    class Node implements Comparable<Node> {
        final int sum;
        String code;

        void buildCode(String code) {
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
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
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
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }

        int count;
    }

    private void run() throws FileNotFoundException {
//        String s = "SUSIE SAYS IT IS EASY";
//        String s = "abacabad";
//        String s = "abccccccc";
        Scanner scanner = new Scanner(new File("C:/000/input.txt"));
        String s = scanner.next();

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
                sorted(Collections.reverseOrder
                        (Map.Entry.comparingByValue())).
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
        Map<Character, Node> characterNodeMap = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            characterNodeMap.put(entry.getKey(), node);
            priorityQueue.add(node);
        }

        int sum = 0;
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }

        if (map.size() == 1) sum = s.length();

        System.out.println(map.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (map.size() == 1) {
            root.buildCode("0");
        } else root.buildCode("");

/*
        String encodeString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            encodeString += characterNodeMap.get(c).code;
        }
        System.out.println(encodeString);
*/
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(characterNodeMap.get(c).code);
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new HuffmanCode().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
