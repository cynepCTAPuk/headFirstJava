package algorithms.stepik2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Test322a {
    public static void main(String[] args) throws IOException {
        final int p = 1_000_000_007;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        LinkedList<String>[] table = new LinkedList[m];
        for (int i = 0; i < m; i++) table[i] = new LinkedList<>();

        int n = Integer.parseInt(reader.readLine());
        long[] x = new long[15];
        x[0] = 1;
        for (int i = 1; i < 15; i++) x[i] = x[i - 1] * 263 % p;

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            char[] c = input[1].toCharArray();
            int idx = 0;
            for (int j = 0; j < c.length; j++) idx = (int) ((idx + c[j] * x[j]) % p);
            idx %= m;
            switch (input[0]) {
                case ("add"):
                    if (!table[idx].contains(input[1])) table[idx].addFirst(input[1]);
                    break;
                case ("del"):
                    table[idx].remove(input[1]);
                    break;
                case ("find"):
                    System.out.println(table[idx].contains(input[1]) ? "yes" : "no");
                    break;
                case ("check"):
                    for (String s : table[Integer.parseInt(input[1])]) System.out.print(s + " ");
                    System.out.println();
            }
        }
    }
}