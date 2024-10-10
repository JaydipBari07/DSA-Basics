package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementUsingMinHeap {

    int k;
    List<Integer> heap;
    Integer lastlargest;

    public KthLargestElementUsingMinHeap(int k, int[] nums) {
        this.k = k;
        heap = new ArrayList<>();
        heap.add(null);

        for (int i : nums) {
            heap.add(i);
            int cur = heap.size() - 1;
            while (cur > 1 && heap.get(cur) < heap.get(cur / 2)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(cur / 2));
                heap.set(cur / 2, temp);
                cur = cur / 2;
            }
        }
        while (this.heap.size() - 1 > k) {
            pop(this.heap);
        }
    }

    public Integer add(int val) {
//            res.add(this.heap);
        heap.add(val);
        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) < heap.get(cur / 2)) {
            int temp = heap.get(cur);
            heap.set(cur, heap.get(cur / 2));
            heap.set(cur / 2, temp);
            cur = cur / 2;
        }
        while (this.heap.size() - 1 > k) {
            pop(this.heap);
        }
        if (heap.size() > 1) {
            lastlargest = heap.get(1);
        }
        return lastlargest;
    }

    public int pop(List<Integer> heap) {
        if (heap.size() <= 1) {
            return -1;
        }
        int val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int i = 1;
        while (i * 2 < heap.size()) {
            if (i * 2 + 1 < heap.size()
                    && heap.get(i * 2 + 1) < heap.get(i)
                    && heap.get(i * 2 + 1) < heap.get(i * 2)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(i * 2 + 1));
                heap.set(i * 2 + 1, temp);
                i = i * 2 + 1;
            } else if (heap.get(i * 2) < heap.get(i)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(i * 2));
                heap.set(i * 2, temp);
                i = i * 2;
            } else {
                break;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        KthLargestElementUsingMinHeap obj = new KthLargestElementUsingMinHeap(1, new int[]{});
        List<Integer> res1 = new ArrayList<>();
//        res.add(obj.heap);
        res1.add(obj.add(-3));
        res1.add(obj.add(-2));
        res1.add(obj.add(-4));
        res1.add(obj.add(0));
        res1.add(obj.add(4));
        System.out.println(res1);
    }
}
