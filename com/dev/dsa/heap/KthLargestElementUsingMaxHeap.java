package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class KthLargestElementUsingMaxHeap {

    int k;
    List<Integer> heap;

    public KthLargestElementUsingMaxHeap(int k, int[] nums) {
        this.k = k;
        heap = new ArrayList<>();
        heap.add(-1);

        for (int i : nums) {
            heap.add(i);
            int cur = heap.size() - 1;
            while (heap.get(cur) > heap.get(cur / 2) && cur > 1) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(cur / 2));
                heap.set(cur / 2, temp);
                cur = cur / 2;
            }
        }
    }

    public int add(int val) {
        // Add val to existing heap
        heap.add(val);
        int cur = heap.size() - 1;
        while (heap.get(cur) > heap.get(cur / 2) && cur > 1) {
            int temp = heap.get(cur);
            heap.set(cur, heap.get(cur / 2));
            heap.set(cur / 2, temp);
            cur = cur / 2;
        }
        List<Integer> heapCopy = new ArrayList<>(this.heap);
        int count = k;
        int max = -1;
        while (count > 0) {
            max = pop(heapCopy);
            count -= 1;
        }
        return max;
    }

    public int pop(List<Integer> heap) {
        if (heap.isEmpty()) {
            return -1;
        }
        int val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int i = 1;
        while (i * 2 < heap.size()) {
            if (i * 2 + 1 < heap.size()
                    && heap.get(i * 2 + 1) > heap.get(i)
                    && heap.get(i * 2 + 1) > heap.get(i * 2)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(i * 2 + 1));
                heap.set(i * 2 + 1, temp);
                i = i * 2 + 1;
            } else if (heap.get(i * 2) > heap.get(i)) {
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
        KthLargestElementUsingMaxHeap obj = new KthLargestElementUsingMaxHeap(3, new int[]{1,2,3,3});
        System.out.println(obj.heap);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(6));
        System.out.println(obj.add(7));
        System.out.println(obj.add(8));
//        System.out.println(obj.pop(new ArrayList<>(obj.heap)));
//        System.out.println(obj.heap);

    }
}
