package algorithms;

import java.util.*;

//  https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
public class Test421a {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        String input = "abacabad";
        String code = "4 14\n" + "a: 0\n" + "b: 10\n" + "c: 110\n" + "d: 111\n" + "01001100100111";

        Node treeHuffman = generateTreeHuffmanFromString(input);
        Map<Character, String> tableHuffman = new HashMap<>();
        createTableHuffman(treeHuffman, String.valueOf(treeHuffman.ch), tableHuffman);
        StringBuilder codeHuffman = printCodeHuffman(input, tableHuffman);

        System.out.println(tableHuffman.size() + " " + codeHuffman.length());
        tableHuffman.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
//                .sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                .forEach(a -> System.out.println(a.getKey() + ": " + a.getValue()));
        System.out.println(codeHuffman);

//        System.out.println(decodeHuffmanFromTreeHuffman("01001100100111", treeHuffman));
        Map<String, Character> map = new HashMap<>();
        map.put("0", 'a');
        map.put("10", 'b');
        map.put("110", 'c');
        map.put("111", 'd');
        System.out.println(decodeFromTableHuffman("01001100100111",map));
    }

    public static String decodeFromTableHuffman(String codeHuffman, Map<String, Character> table) {
        char[] chars = codeHuffman.toCharArray();
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < chars.length) {
            String code = "" + chars[index++];
            while (!table.containsKey(code) && index < chars.length) {
                code += chars[index++];
            }
            result.append(table.get(code));
        }
        return result.toString();
    }

    public static String decodeFromTreeHuffman(String codeHuffman, Node treeHuffman) {
        if (treeHuffman == null) return "";

        char[] chars = codeHuffman.toCharArray();
        int index = 0;
        StringBuilder result = new StringBuilder();
        while (index < chars.length) {
            Node node = treeHuffman;
            while (node != null) {
                if (node.left == null && node.right == null) {
                    result.append(node.ch);
                    break;
                } else {
                    char c = chars[index];
                    if (c == '0') node = node.left;
                    else node = node.right;
                    index++;
                }
            }
        }
        return result.toString();
    }

    public static Node generateTreeHuffmanFromString(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) map.merge(c, 1, Integer::sum);

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.freq - o2.freq);
        for (Character c : map.keySet()) {
            Node node = new Node(c, map.get(c), null, null);
            queue.add(node);
        }
        Node root = null;
        while (queue.size() > 1) {
            Node x = queue.poll();
            Node y = queue.poll();
            Node newNode = new Node('\0', x.freq + y.freq, x, y);
            root = newNode;
            queue.add(newNode);
        }
        return root;
    }

    public static void createTableHuffman(
            Node root, String string, Map<Character, String> output) {
        if (root.left == null && root.right == null) {
//            System.out.println(root.ch + ":" + string);
            output.put(root.ch, string);
            return;
        }
        createTableHuffman(root.left, string + "0", output);
        createTableHuffman(root.right, string + "1", output);
    }

    public static StringBuilder printCodeHuffman(String input, Map<Character, String> table) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) sb.append(table.get(ch));
        return sb;
    }

    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        int depth() {
            return (size() + 1) / 2;
        }

        int size() {
            return size(this);
        }

        private int size(Node n) {
            return n == null ? 0 : size(n.left) + 1 + size(n.right);
        }

        @Override
        public String toString() {
            return "Node{" +
                           "ch=" + ch +
                           ", freq=" + freq +
                           ", left=" + left +
                           ", right=" + right +
                           '}';
        }
    }
}