package algorithms;

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
//  https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
public class Test421a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Node treeHuffman = generateTreeHuffman(input);
        String codeHuffman = generateCodeHuffman(input, treeHuffman);

        System.out.println(input.length() + " " + codeHuffman.length());
        printTableHuffman(treeHuffman);
        System.out.println(codeHuffman);
    }

    private static String generateCodeHuffman(String input, Node treeHuffman) {
        for (char c : input.toCharArray()) {

        }
        return "test";
    }

    public static void printTableHuffman(Node root) {
        tableHuffman(root, "");
    }

    public static void tableHuffman(Node root, String string) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + string);
            return;
        }
        tableHuffman(root.left, string + "0");
        tableHuffman(root.right, string + "1");
    }

    public static Node generateTreeHuffman(String input) {
        int n = input.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) map.merge(c, 1, Integer::sum);

        // creating a priority queue queue, makes a min-priority queue(min-heap)
        PriorityQueue<Node> queue = new PriorityQueue<>(n, (o1, o2) -> o1.data - o2.data);
        for (Character c : map.keySet()) {
            Node node = new Node(c, map.get(c), null, null);
            queue.add(node);
        }
        // create a root node
        Node root = null;
        // Here we will extract the two minimum value from the heap each time until
        // its size reduces to 1, extract until all the nodes are extracted.
        while (queue.size() > 1) {
            Node x = queue.poll();  // first min extract.
            Node y = queue.poll();  // second min extarct.
            // newNode value is equal to the sum of the frequency of the two nodes values.
            // first extracted node as left child, second extracted node as the right child.
            Node newNode = new Node('-', x.data + y.data, x, y);
            root = newNode;               // marking the newNode node as the root node.
            queue.add(newNode);           // add this node to the priority-queue.
        }
        return root;
    }

    static class Node {
        char c;
        int data;
        Node left;
        Node right;

        public Node(char c, int data, Node left, Node right) {
            this.c = c;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}


