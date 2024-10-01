package com.dev.dsa.binarySearch.rangeSearch;

public class EatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int min = 0, max = piles[0];
        for (int i : piles) {
            if (i > max) {
                max = i;
            }
        }
        int lastCount = -1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canEatWithinLimit(piles, mid, h)) {
                lastCount = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return lastCount;
    }

    public static boolean canEatWithinLimit(int[] piles, int eatLimit, int hoursLimit) {
        int count = 0;
        for (int i : piles) {
            int mod = i % eatLimit;
            int totalBananas = (i / eatLimit);
            count += (mod > 0) ? (totalBananas + 1) : totalBananas;
            if (count > hoursLimit)
                return false;
        }
        return count <= hoursLimit;
    }

    public static void main(String[] args) {
        int[] piles = {25, 10, 23, 4};
//        System.out.println(canEatWithinLimit(piles, 20, 5));
        System.out.println(minEatingSpeed(piles, 4));
    }
}
