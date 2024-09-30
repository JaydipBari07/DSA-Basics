package com.dev.dsa.sorting;

public class BucketSort {

    public static void sortColors(int[] nums) {
        int[] possibilities = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            possibilities[nums[i]] += 1;
        }
        int cur = 0;
        for (int i = 0; i < possibilities.length; i++) {
            int j = cur;
            for (; j < cur + possibilities[i]; j++) {
                nums[j] = i;
            }
            cur = j;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,0,1,2,1,0,0,2,2,1,0};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        sortColors(arr);

    }
}
