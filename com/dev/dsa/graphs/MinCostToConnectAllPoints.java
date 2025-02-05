package com.dev.dsa.graphs;

import com.dev.dsa.UnionFind.UnionFind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    /**
     * 71/72 cases passed. Last TC failed with Time Limit Exceeded.
     */
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[][] distanceGrid = new int[len][len];
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(l -> l.get(2)));
        for (int i = 0; i < len; i++) {
            for (int j = 0; i != j && j < len; j++) {
                if (distanceGrid[i][j] == 0) {
                    int dist = calculateDistance(points[i], points[j]);
                    distanceGrid[i][j] = dist;
                    distanceGrid[j][i] = dist;
                    minHeap.add(Arrays.asList(i, j, dist));
                }
            }
        }
        UnionFind unionFind = new UnionFind(len);
        int sum = 0;
        int i = 0;
        while (i < len && !minHeap.isEmpty()) {
            List<Integer> node = minHeap.remove();
            if (!unionFind.union(node.get(0), node.get(1))) {
                continue;
            }
            i++;
            sum += node.get(2);
        }
        return sum;
    }

    public int calculateDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(points));
    }
}
