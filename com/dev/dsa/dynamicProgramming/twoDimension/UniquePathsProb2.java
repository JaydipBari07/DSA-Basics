package com.dev.dsa.dynamicProgramming.twoDimension;

public class UniquePathsProb2 {
    int rn, cn;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        rn = obstacleGrid.length;
        cn = obstacleGrid[0].length;
        return uniquePaths(obstacleGrid, 0, 0, new int[rn][cn]);
    }

    public int uniquePaths(int[][] grid, int r, int c, int[][] cache) {
        if (r == rn || c == cn || grid[r][c] != 0) {
            return 0;
        }
        if (r == rn - 1 && c == cn - 1) {
            return 1;
        }
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        cache[r][c] = uniquePaths(grid, r + 1, c, cache) + uniquePaths(grid, r, c + 1, cache);
        return cache[r][c];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1}};
        System.out.println(new UniquePathsProb2().uniquePathsWithObstacles(grid));
    }
}
