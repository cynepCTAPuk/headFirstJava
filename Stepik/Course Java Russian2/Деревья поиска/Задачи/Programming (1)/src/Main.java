import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        int[] key = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = scanner.nextInt();
            left[i] = scanner.nextInt();
            right[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) nodes[i] = new Node();
        for (int i = 0; i < n; i++) {
            nodes[i].key = key[i];
            if (left[i] > -1) nodes[i].left = nodes[left[i]];
            if (right[i] > -1) nodes[i].right = nodes[right[i]];
        }

        List<Integer> arrayList = new ArrayList<>();
        if (n > 0) Node.inOrderTree(nodes[0], arrayList);
        System.out.println(checkSortedList(arrayList));
    }

    public static String checkSortedList(List<Integer> arrayList) {
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i - 1) >= arrayList.get(i)) {
                return "INCORRECT";
            }
        }
        return "CORRECT";
    }

    private static class Node {
        int key;
        Node left, right;

        static void inOrderTree(Node node, List<Integer> list) {
            if (node != null) {
                inOrderTree(node.left, list);
                list.add(node.key);
                inOrderTree(node.right, list);
            }
        }
    }
}