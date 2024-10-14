package com.dev.dsa.dynamicProgramming.oneDimension;

import java.util.HashMap;

// This implementation works only without cache. And without cache implementation gives time limit exceeded error.
public class HouseRobberIncludeNotInclude {

    public int rob(int[] nums) {
        return calculateAmount(nums, 0, 0, new HashMap<>());
    }

    public int calculateAmount(int[] nums, int sum, int cur, HashMap<Integer, Integer> cache) {
        if (cur >= nums.length) {
            return sum;
        }
        if (cur == nums.length - 1) {
            return sum + nums[cur];
        }
        if (cache.containsKey(cur)) {
            return cache.get(cur);
        }
        int max = 0;
        int newSum = 0;
        max = calculateAmount(nums, sum + nums[cur], cur + 2, cache);  // check with including the cur element
        newSum = calculateAmount(nums, sum, cur + 1, cache); // check without including cur element
        if (newSum > max) {
            max = newSum;
        }
        cache.put(cur, max);
        return max;
    }

    // TODO: find a way for cache to work properly.
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 7, 1, 1, 9};
        System.out.println(new HouseRobberIncludeNotInclude().rob(nums));
    }
}
