package com.dev.dsa.dynamicProgramming.twoDimension;

public class UniquePathsProb2BottomUpApproach {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rn, cn;
        rn = obstacleGrid.length;
        cn = obstacleGrid[0].length;
        if (obstacleGrid[rn - 1][cn - 1] == 1) {
            return 0;
        }
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < cn; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        for (int i = cn - 1; i >= 0; i--) {
            if (obstacleGrid[rn - 1][i] == -1) {
                break;
            }
            obstacleGrid[rn - 1][i] = 1;
        }
        for (int i = rn - 1; i >= 0; i--) {
            if (obstacleGrid[i][cn - 1] == -1) {
                break;
            }
            obstacleGrid[i][cn - 1] = 1;
        }

        for (int r = rn - 2; r >= 0; r--) {
            for (int c = cn - 2; c >= 0; c--) {
                if (obstacleGrid[r][c] == -1) {
                    continue;
                }
                if (obstacleGrid[r + 1][c] != -1) {
                    obstacleGrid[r][c] += obstacleGrid[r + 1][c];
                }
                if (obstacleGrid[r][c + 1] != -1) {
                    obstacleGrid[r][c] += obstacleGrid[r][c + 1];
                }
            }
        }
        if (obstacleGrid[0][0] > 0) {
            return obstacleGrid[0][0];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsProb2BottomUpApproach().uniquePathsWithObstacles(grid));
    }
}
