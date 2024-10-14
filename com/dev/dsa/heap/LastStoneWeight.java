package com.dev.dsa.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LastStoneWeight {

    List<Integer> heap;

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return -1;
        }
        heapify(stones);
        while (heap.size() > 2) {
            int val1 = pop();
            int val2 = pop();
            if (val1 != val2) {
                push(Math.abs(val1 - val2));
            }
        }
        if (heap.size() == 2) {
            return heap.get(1);
        }
        return 0;
    }

    public void push(int val) {
        heap.add(val);
        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) > heap.get(cur / 2)) {
            int temp = heap.get(cur);
            heap.set(cur, heap.get(cur / 2));
            heap.set(cur / 2, temp);
            cur = cur / 2;
        }
    }

    public void heapify(int[] nums) {
        heap = new ArrayList<>();
        heap.add(null);
        heap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int i = (nums.length / 2);
        while (i >= 1) {
            int cur = i;
            while (cur * 2 < heap.size()) {
                if (cur * 2 + 1 < heap.size()
                        && heap.get(cur * 2 + 1) > heap.get(cur * 2)
                        && heap.get(cur * 2 + 1) > heap.get(cur)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(cur * 2 + 1));
                    heap.set(cur * 2 + 1, temp);
                    cur = cur * 2 + 1;
                } else if (heap.get(cur * 2) > heap.get(cur)) {
                    int temp = heap.get(cur);
                    heap.set(cur, heap.get(cur * 2));
                    heap.set(cur * 2, temp);
                    cur = cur * 2;
                } else {
                    break;
                }
            }
            i -= 1;
        }
    }

    public int pop() {
        int val = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int cur = 1;
        while (cur * 2 < heap.size()) {
            if (cur * 2 + 1 < heap.size()
                    && heap.get(cur * 2 + 1) > heap.get(cur * 2)
                    && heap.get(cur * 2 + 1) > heap.get(cur)) {
                int temp = heap.get(cur);
                heap.set(cur, heap.get(cur * 2 + 1));
                heap.set(cur * 2 + 1, temp);
                cur = cur * 2 + 1;
            } else if (heap.get(cur * 2) > heap.get(cur)) {
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
        int[] nums = new int[]{2, 3, 6, 2, 4};
        LastStoneWeight obj = new LastStoneWeight();
        System.out.println(obj.lastStoneWeight(nums));
    }
}
