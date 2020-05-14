import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        LinkedList<String>[] table = new LinkedList[m];

        int n = Integer.parseInt(scanner.nextLine());
        String[] queries = new String[n];
        for (int i = 0; i < n; i++) {
            queries[i] = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            String[] input = queries[i].split(" ");
            String command = input[0];
            String string;
            switch (command) {
                case "add":
                    add(input[1], table);
                    break;
                case "find":
                    find(input[1], table);
                    break;
                case "del":
                    del(input[1], table);
                    break;
                case "check":
                    check(Integer.parseInt(input[1]), table);
            }
        }
    }

    private static void add(String s, LinkedList<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            table[i] = new LinkedList<>();
        }
        if (table[i].contains(s)) {
            return;
        }
        table[i].addFirst(s);
    }

    private static void del(String s, List<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            return;
        }
        table[i].remove(s);
    }

    private static void find(String s, List<String>[] table) {
        int i = index(s, table.length);
        if (table[i] == null) {
            System.out.println("no");
            return;
        }
        System.out.println(table[i].contains(s) ? "yes" : "no");
    }

    private static void check(int i, List<String>[] table) {
        List<String> list = table[i];
        if (list == null) {
            System.out.println();
        } else {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static int index(String s, int m) {
        BigInteger p = new BigInteger("1000000007");
        BigInteger x = new BigInteger("263");
        BigInteger u = BigInteger.valueOf(m);
        BigInteger result = BigInteger.ZERO;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            BigInteger c = new BigInteger("" + (int) charArray[i]);
            BigInteger t = x.pow(i);
            result = result.add(t.multiply(c));
        }
        result = result.mod(p);
        return result.mod(u).intValue();
    }
}
