package com.dev.dsa.dynamicProgramming.oneDimension;

public class HouseRobberImpl3 {

    public int rob(int[] nums) {

        int sum1 = 0, sum2 = 0;
        for (int i : nums) {
            int temp = sum2;
            sum2 = Math.max(sum1 + i, sum2);
            sum1 = temp;
        }
        return sum2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 7, 1, 1, 9};
        System.out.println(new HouseRobberImpl3().rob(nums));
    }
}
