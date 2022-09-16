package algorithms.stepik2;

import java.util.Scanner;

public class Test233b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tablesCount = scanner.nextInt();
        int requestsCount = scanner.nextInt();
        DisjointSet set = new DisjointSet(tablesCount);
        for (int i = 0; i < tablesCount; i++) set.initSet(i, scanner.nextInt());
        for (int i = 0; i < requestsCount; i++) {
            set.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
            System.out.println(set.maxRank);
        }
    }

    private static class DisjointSet {
        private final int[] set;
        private final int[] rank;
        private int maxRank;

        DisjointSet(int tablesCount) {
            set = new int[tablesCount];
            rank = new int[tablesCount];
        }

        void initSet(int position, int entryCount) {
            set[position] = position;
            rank[position] = entryCount;
            maxRank = Math.max(entryCount, maxRank);
        }

        int find(int i) {
            if (i != set[i]) set[i] = find(set[i]);
            return set[i];
        }

        void union(int destination, int source) {
            int destinationID = find(destination);
            int sourceID = find(source);

            if (destinationID == sourceID) return;

            set[sourceID] = destinationID;
            rank[destinationID] += rank[sourceID];
            maxRank = Math.max(rank[destinationID], maxRank);
        }
    }
}