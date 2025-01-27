package com.dev.dsa.arrays.slidingWindow;

/**
 * LeetCode: 209
 */
public class MinimumSizeSubarraySum {

    /**
     * TC: 19.80%
     * SC: 30.75%
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 1, len = nums.length, minSize = Integer.MAX_VALUE, curSum, curSize;
        curSum = nums[left];
        curSize = 1;
        if (curSum >= target) {
            return 1;
        }
        while (right < len) {
            curSum += nums[right];
            curSize++;
            if (curSum >= target) {
                minSize = Math.min(curSize, minSize);
            }
            while (left <= right && curSum - nums[left] >= target) {
                curSize--;
                curSum -= nums[left];
                left++;
                minSize = Math.min(curSize, minSize);
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int[] nums1 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums2 = new int[]{1, 4, 4};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11, nums1));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(4, nums2));
    }
}
