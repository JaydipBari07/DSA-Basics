package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class KthLargestInArray {

    List<Integer> heap;

    public int findKthLargest(int[] nums, int k) {
        heap = new ArrayList<>();
        heap.add(null);
        for (int i : nums) {
            push(i);
        }
        while (heap.size() - 1 > k) {
            pop();
        }
        return pop();
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

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4};
        KthLargestInArray obj = new KthLargestInArray();
        System.out.println(obj.findKthLargest(nums, 2));
    }
}
