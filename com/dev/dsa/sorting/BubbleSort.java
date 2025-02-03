package com.dev.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Adjacent elements are swapped if they are in wrong order.
     * This process is repeated n times
     * At the end of each repetition, array has the maximum element at its end.
     */
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 3, 2, 1, 6};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
