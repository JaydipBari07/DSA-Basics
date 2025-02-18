package com.dev.dsa.bitOperations;

public class NumberOfSetBits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count += 1;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSetBits().hammingWeight(11));
    }
}
