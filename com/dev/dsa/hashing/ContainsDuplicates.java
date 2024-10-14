package com.dev.dsa.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicates {

    public static boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                return true;
            } else {
                hashMap.put(i, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(hasDuplicate(arr));
        int[] arr2 = {1,2,1,3,4};
        System.out.println(hasDuplicate(arr2));
    }
}
