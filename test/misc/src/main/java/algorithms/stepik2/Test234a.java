package algorithms.stepik2;

import util.Util;

import java.util.Scanner;

public class Test234a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int d = sc.nextInt();
        int[] parents = new int[n + 1];
        for (int i = 1; i <= n; i++) parents[i] = i;
        for (int i = 0; i < e; i++) linking(sc.nextInt(), sc.nextInt(), parents);
        int result = 1;
        for (int i = 0; i < d; i++) {
            if (parents[sc.nextInt()] == parents[sc.nextInt()]) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    public static void linking(int first, int second, int[] parents) {
        while (second != parents[second]) {
            int temp = second;
            second = parents[second];
            parents[temp] = parents[first];
        }
        parents[second] = parents[first];
    }
}