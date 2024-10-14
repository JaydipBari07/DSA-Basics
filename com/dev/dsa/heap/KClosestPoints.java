package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestPoints {

    List<int[]> heap;

    public int[][] kClosest(int[][] points, int k) {
        heap = new ArrayList<>();
        heap.add(null);
        for (int[] i : points) {
            push(i);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pop();
        }
        return res;
    }

    public double findDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    public void push(int[] val) {
        heap.add(val);
        int cur = heap.size() - 1;
        while (cur / 2 >= 1 && findDistance(heap.get(cur / 2)) > findDistance(heap.get(cur))) {
            System.out.println(findDistance(heap.get(cur / 2)) + " " + findDistance(heap.get(cur)));
            int[] temp = heap.get(cur);
            heap.set(cur, heap.get(cur / 2));
            heap.set(cur / 2, temp);
            cur = cur / 2;
        }
    }

    public int[] pop() {
        if (heap.size() <= 1) {
            return null;
        }
        int[] val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int cur = 1;
        while (cur * 2 < heap.size()) {
            if (cur * 2 + 1 < heap.size()
                    && findDistance(heap.get(2 * cur + 1)) < findDistance(heap.get(2 * cur))
                    && findDistance(heap.get(cur)) > findDistance(heap.get(cur * 2 + 1))) {
                int[] temp = heap.get(cur);
                heap.set(cur, heap.get(cur * 2 + 1));
                heap.set(cur * 2 + 1, temp);
                cur = cur * 2 + 1;
            } else if (findDistance(heap.get(cur * 2)) < findDistance(heap.get(cur))) {
                int[] temp = heap.get(cur);
                heap.set(cur, heap.get(cur * 2));
                heap.set(cur * 2, temp);
                cur = cur * 2;
            } else {
                break;
            }
        }
        return val;
    }

    public void printHeap() {
        for (int[] point : heap) {
            System.out.print(Arrays.toString(point));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, -2}};
        int k = 1;
        KClosestPoints obj = new KClosestPoints();
        System.out.println(Arrays.deepToString(obj.kClosest(nums, k)));
//        obj.printHeap();
//        System.out.println(Arrays.deepToString(obj.kClosest(nums, k)));
//        obj.printHeap();
    }

}
