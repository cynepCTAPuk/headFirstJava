import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }

        String[] operations = new String[n];
        String[] operands = new String[n];
        for (int i = 0; i < n; i++) {
            String[] words = lines[i].split(" ");
            operations[i] = words[0].trim();
            if (words.length > 1) {
                operands[i] = words[1].trim();
            } else operands[i] = "0";
        }
        for (int i = 0; i < n; i++) {
            String operation = operations[i];
            if (operation.equals("Insert")) {
                insert(Integer.parseInt(operands[i].trim()));
            } else if (operation.equals("ExtractMax")) {
                System.out.println(extractMax());
            }
        }
    }

    private static void insert(int element) {
        list.add(element);
        siftUp(element, list.size() - 1);
    }

    private static int extractMax() {
        int size = list.size();
        if (size > 1) {
            int max = list.get(0);
            int last = list.get(size - 1);
            list.set(0, last);
            list.remove(size - 1);
            siftDown(list.get(0), 0);
            return max;
        } else return list.remove(0);
    }

    private static void siftDown(int element, int index) {
        int iLeft = 2 * index + 1;
        int iRight = 2 * index + 2;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if (iLeft < list.size()) {
            left = list.get(iLeft);
        }
        if (iRight < list.size()) {
            right = list.get(iRight);
        }
        int iMax;
        int max;
        if (left > right) {
            iMax = iLeft;
            max = left;
        } else {
            iMax = iRight;
            max = right;
        }
        if (element < max) {
            list.set(index, max);
            list.set(iMax, element);
            siftDown(element, iMax);
        }
    }

    private static void siftUp(int element, int index) {
        int iParent = (index - 1) / 2;
        int parent = list.get(iParent);
        if (parent < element) {
            list.set(iParent, element);
            list.set(index, parent);
            siftUp(element, iParent);
        }
    }
}