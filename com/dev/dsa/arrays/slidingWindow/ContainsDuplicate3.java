package com.dev.dsa.arrays.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode: 219
 */
public class ContainsDuplicate3 {

    /**
     * TC: 93.80%
     * SC: 97.34%
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 1, len = nums.length;
        Set<Integer> set = new HashSet<>();
        set.add(nums[left]);
        while (right < len) {
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }
            if (set.contains(nums[right])) {
                return true;
            }
            set.add(nums[right]);
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 3};
        System.out.println(new ContainsDuplicate3().containsNearbyDuplicate(nums, 2));
    }
}
