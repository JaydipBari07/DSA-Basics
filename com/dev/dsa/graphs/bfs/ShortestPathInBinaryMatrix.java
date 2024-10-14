package com.dev.dsa.graphs.bfs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathInBinaryMatrix {

    int rn, cn;
    List<Pair<Integer, Integer>> queue;
    int[][] neighbors = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        rn = grid.length;
        cn = grid.length;
        if (grid[0][0] == 1 || grid[rn - 1][cn - 1] == 1) {
            return -1;
        }
        queue = new ArrayList<>();
        queue.add(new Pair<>(0, 0));
        grid[0][0] = -1;
        int count = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pair<Integer, Integer> pair = queue.remove(0);
                int r = pair.getKey(), c = pair.getValue();
                if (r == rn - 1 && c == cn - 1) {
                    return count;
                }
                for (int[] p : neighbors) {
                    int newR = r + p[0];
                    int newC = c + p[1];
                    if (newR < 0 || newC < 0 || newR == rn || newC == cn || grid[newR][newC] != 0) {
                        continue;
                    }
                    queue.add(new Pair<>(newR, newC));
                    grid[newR][newC] = -1;
                }
            }
            count += 1;
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(grid));
    }
}
