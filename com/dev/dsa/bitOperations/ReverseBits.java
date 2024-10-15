package com.dev.dsa.bitOperations;

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        StringBuilder builder = new StringBuilder();
        int count = 32;
        boolean flag = false;
        while (count > 0) {
            if (n == 0) {
                flag = true;
            }
            if (!flag) {
                if ((n & 1) == 1) {
                    builder.append(1);
                } else {
                    builder.append(0);
                }
                n = n >> 1;
            } else {
                builder.append(0);
            }
            count -= 1;
        }
        String s1 = builder.toString();
        return Integer.parseInt(s1, 2);
    }

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(new ReverseBits().reverseBits(n));
    }
}
