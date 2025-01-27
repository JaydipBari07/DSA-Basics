package com.dev.dsa.arrays.slidingWindow;

/**
 * LeetCode: 1343
 */
public class SubarrayWithAverage {

    /**
     * TC: 90.52%
     * SC: 19.22%
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = 1, len = arr.length, sum, count = 0;
        sum = arr[left];
        threshold = threshold * k;
        while (right < len) {
            if (right - left + 1 > k) {
                if (sum >= threshold) {
                    count++;
                }
                sum -= arr[left];
                left++;
            }
            sum += arr[right];
            right++;
        }
        if (sum >= threshold) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
        int[] arr1 = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        System.out.println(new SubarrayWithAverage().numOfSubarrays(arr, 3, 4));
        System.out.println(new SubarrayWithAverage().numOfSubarrays(arr1, 3, 5));
    }
}
