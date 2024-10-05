package com.dev.dsa.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SubSets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        addSubsets(res, subset, nums, 0);
        return res;
    }

    public static void addSubsets(List<List<Integer>> res, List<Integer> subset, int[] nums, int cur) {
        if(cur >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        addSubsets(res, new ArrayList<>(subset), nums, cur + 1);
        subset.add(nums[cur]);
        addSubsets(res, new ArrayList<>(subset), nums, cur + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
