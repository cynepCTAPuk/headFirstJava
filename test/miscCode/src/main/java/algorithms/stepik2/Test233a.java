package algorithms.stepik2;

import java.util.Scanner;

public class Test233a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DisjointSets sets = new DisjointSets(n);
        for (int i = 0; i < n; i++) sets.makeSet(i, sc.nextInt());
        int[] left = new int[m];
        int[] right = new int[m];
        for (int i = 0; i < m; i++) {
            left[i] = sc.nextInt() - 1;
            right[i] = sc.nextInt() - 1;
        }
        for (int i = 0; i < m; i++) {
            sets.union(left[i], right[i]);
            System.out.println(sets.max);
        }
/*
        for (int i = 0; i < m; i++) {
            sets.union(sc.nextInt() - 1, sc.nextInt() - 1);
            System.out.println(sets.max);
        }
*/
    }

    static class DisjointSets {
        private final int[] parents;    //parents
        private final int[] ranks;      //ranks
        private final int[] items;      //items
        private int max;

        DisjointSets(int capacity) {
            parents = new int[capacity];
            ranks = new int[capacity];
            items = new int[capacity];
        }

        void makeSet(int id, int value) {
            items[id] = value;
            parents[id] = id;
            max = Math.max(max, value);
        }

        int find(int id) {
            if (parents[id] != id) parents[id] = find(parents[id]);
            return parents[id];
        }

        void union(int left, int right) {
            int leftRoot = find(left);
            int rightRoot = find(right);

            if (leftRoot == rightRoot) return;

            if (ranks[leftRoot] < ranks[rightRoot]) {
                parents[leftRoot] = rightRoot;
                items[rightRoot] += items[leftRoot];
                max = Math.max(max, items[rightRoot]);
            } else {
                parents[rightRoot] = leftRoot;
                items[leftRoot] += items[rightRoot];
                max = Math.max(max, items[leftRoot]);
                if (ranks[leftRoot] == ranks[rightRoot]) ranks[leftRoot]++;
            }
        }
    }
}