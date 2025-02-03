package com.dev.dsa.sorting;

import java.util.Arrays;

public class MergeSortNew {

    public void sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start];
        int cur = 0, i = start, j = mid + 1;
        while (i <= mid && j < end) {
            if (nums[i] < nums[j]) {
                temp[cur] = nums[i];
                i++;
            } else {
                temp[cur] = nums[j];
                j++;
            }
            cur++;
        }
        cur = 0;
        for (i = start; i < end; i++, cur++) {
            nums[i] = temp[cur];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 3, 2, 1, 6};
        new MergeSortNew().sort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
