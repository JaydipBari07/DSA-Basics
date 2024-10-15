package com.dev.dsa.dynamicProgramming.twoDimension;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] grid = new int[text1.length() + 1][text2.length() + 1];
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    grid[i][j] = 1 + grid[i + 1][j + 1];
                } else {
                    grid[i][j] = Math.max(grid[i + 1][j], grid[i][j + 1]);
                }
            }
        }

        return grid[0][0];
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "ace";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(s1, s2));
    }
}
