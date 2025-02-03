package com.dev.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Get each element and swap it with minimum element from rest of the array.
     */
    public void sort(int[] nums) {
        int min, len = nums.length;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 1, 0};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
