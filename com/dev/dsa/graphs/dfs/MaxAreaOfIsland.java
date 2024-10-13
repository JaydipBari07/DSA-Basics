package com.dev.dsa.graphs.dfs;

public class MaxAreaOfIsland {

    int rn, cn;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rn = grid.length;
        cn = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                if (grid[i][j] == 1) {
                    int temp = calculateArea(grid, i, j);
                    if(temp > maxArea){
                        maxArea = temp;
                    }
                }
            }
        }
        return maxArea;
    }

    public int calculateArea(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == rn || c == cn || grid[r][c] == -1 || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = -1;
        int count = 1;
        count += calculateArea(grid, r + 1, c);
        count += calculateArea(grid, r - 1, c);
        count += calculateArea(grid, r, c + 1);
        count += calculateArea(grid, r, c - 1);
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}
