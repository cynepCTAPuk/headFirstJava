package chap13_strings;
import java.io.*;
import java.util.*;

public class FastRead {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream stream) {
            try { br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) { e.printStackTrace(); }
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine());
                } catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}