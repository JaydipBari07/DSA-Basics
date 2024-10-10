package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(null);
    }

    public void push(int val) {
        heap.add(val);
        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int temp = heap.get(cur);
            heap.set(cur, heap.get(cur / 2));
            heap.set(cur / 2, temp);
            cur = cur / 2;
        }
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }
        int val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int cur = 1;
        while (cur * 2 < heap.size()) {
            if (cur * 2 + 1 < heap.size()
                    && heap.get(2 * cur + 1) < heap.get(2 * cur)
                    && heap.get(cur) > heap.get(cur * 2 + 1)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(cur * 2 + 1));
                heap.set(cur * 2 + 1, temp);
                cur = cur * 2 + 1;
            } else if (heap.get(cur * 2) < heap.get(cur)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(cur * 2));
                heap.set(cur * 2, temp);
                cur = cur * 2;
            } else {
                break;
            }
        }
        return val;
    }

    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    public void heapify(List<Integer> nums) {
        if (nums.isEmpty()) {
            return;
        }
        heap.addAll(nums);

        int i = (nums.size() - 1) / 2;
        while (i >= 1) {
            int cur = i;
            while (cur * 2 < heap.size()) {
                if (cur * 2 + 1 < heap.size()
                        && heap.get(cur * 2 + 1) < heap.get(cur * 2)
                        && heap.get(cur * 2 + 1) < heap.get(cur)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(cur * 2 + 1));
                    heap.set(cur * 2 + 1, temp);
                    cur = 2 * cur + 1;
                } else if (heap.get(cur * 2) < heap.get(cur)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(cur * 2));
                    heap.set(cur * 2, temp);
                    cur = 2 * cur;
                } else {
                    break;
                }
            }
            i -= 1;
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
//        heap.push(10);
//        heap.push(11);
//        heap.push(0);
//        heap.push(4);
//        heap.push(-3);
//        heap.push(100);
//        System.out.println(heap.pop());
//        System.out.println(heap.heap);
//        System.out.println(heap.pop());
//        System.out.println(heap.heap);
//        System.out.println(heap.top());
        heap.heapify(Arrays.asList(3, 2, 1, 4, 1, 5));
        System.out.println(heap.heap);
    }
}
