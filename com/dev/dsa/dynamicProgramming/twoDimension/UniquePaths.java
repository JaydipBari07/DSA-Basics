package com.dev.dsa.dynamicProgramming.twoDimension;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];

        for (int r = m - 1; r >= 0; r--) {
            int[] cur = new int[n];
            cur[n - 1] = 1;
            for (int c = n - 2; c >= 0; c--) {
                cur[c] = cur[c + 1] + prev[c];
            }
            prev = cur;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(new UniquePaths().uniquePaths(m, n));
    }
}
