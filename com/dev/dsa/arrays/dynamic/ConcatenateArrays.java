package com.dev.dsa.arrays.dynamic;

import java.util.Arrays;

public class ConcatenateArrays {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(concatenate(arr)));
    }

    public static int[] concatenate(int[] arr){
        int[] ans = new int[(arr.length) * 2];
        System.out.println(ans.length);
        for(int i = 0; i < ans.length; i++){
            ans[i] = arr[i % arr.length];
        }
        return ans;
    }
}
