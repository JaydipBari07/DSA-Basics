package com.dev.dsa.graphs.dfs;

public class NumberOfIslands {

    int rn, cn;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rn = grid.length;
        cn = grid[0].length;
        int count = 0;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                if (grid[i][j] != '2' && grid[i][j] == '1') {
                    //call count island
                    countIslands(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    public void countIslands(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= rn || c >= cn || grid[r][c] == '2' || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '2';
        countIslands(grid, r + 1, c);
        countIslands(grid, r - 1, c);
        countIslands(grid, r, c + 1);
        countIslands(grid, r, c - 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                                    {'1', '1', '0', '0', '0'},
                                    {'0', '0', '1', '0', '0'},
                                    {'0', '0', '0', '1', '1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
