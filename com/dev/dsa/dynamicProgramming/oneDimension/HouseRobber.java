package com.dev.dsa.dynamicProgramming.oneDimension;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber {

    public int rob(int[] nums) {
        return calculateAmount(nums, new ArrayList<>(), 0, -1);
    }

    public int calculateAmount(int[] nums, List<Integer> visited, int sum, int cur) {
        int maxSum = sum;
        for (int i = cur + 1; i < nums.length; i++) {
            if (!visited.contains(i - 1)) {
                visited.add(i);
                int newSum = calculateAmount(nums, visited, sum + nums[i], i);
                if (newSum > maxSum) {
                    maxSum = newSum;
                }
                visited.remove(new Integer(i));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 7, 1, 1, 9};
        System.out.println(new HouseRobber().rob(nums));
    }
}
