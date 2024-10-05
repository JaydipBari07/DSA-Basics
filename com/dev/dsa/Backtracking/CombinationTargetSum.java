package com.dev.dsa.Backtracking;

import java.util.*;

public class CombinationTargetSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        findCombinations(res, subset, nums, target, 0);
        return res;
    }

    public static void findCombinations(List<List<Integer>> res, List<Integer> comb, int[] nums, int target, int curSum) {
        if (curSum > target) {
            return;
        }
        if (curSum == target && !isExisting(res, comb)) {
            res.add(comb);
            return;
        }
        for (int i : nums) {
            comb.add(i);
            curSum += i;
            findCombinations(res, new ArrayList<>(comb), nums, target, curSum);
            curSum -= i;
            comb.remove(comb.size() - 1);
        }
    }

    public static boolean isExisting(List<List<Integer>> res, List<Integer> comb) {
        return res.stream().filter(c -> c.size() == comb.size())
                .map(c -> {
                    for (int i : new HashSet<>(comb)) {
                        if (Collections.frequency(c, i) != Collections.frequency(comb, i)) {
                            return false;
                        }
                    }
                    return true;
                })
                .filter(val -> val)
                .findFirst().orElse(false);
    }

    public static void main(String[] args) {
        int[] nums = {5, 10, 8, 4, 3, 12, 9};
        System.out.println(combinationSum(nums, 27));
    }
}
