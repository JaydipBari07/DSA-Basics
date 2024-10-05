package com.dev.dsa.Backtracking;

import java.util.*;

public class CombinationTargetSumEfficient {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        addSubsets(res, subset, 0, target, nums, 0);
        return res;
    }

    public static void addSubsets(List<List<Integer>> res, List<Integer> subset, int i, int target, int[] nums, int curSum) {
        if (curSum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (i >= nums.length || curSum > target) {
            return;
        }
        subset.add(nums[i]);
        addSubsets(res, subset, i, target, nums, curSum + nums[i]);
        subset.remove(subset.size() - 1);
        addSubsets(res, subset, i + 1, target, nums, curSum);
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,9};
        System.out.println(combinationSum(nums, 9));
    }

}
