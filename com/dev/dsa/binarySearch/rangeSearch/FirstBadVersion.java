package com.dev.dsa.binarySearch.rangeSearch;

public class FirstBadVersion {
    static int firstBadVersion = 5;

    public static int firstBadVersion(int n) {
        int lastBadVersion = -1;
        int start = 1, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBad(mid)) {
                lastBadVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lastBadVersion;
    }

    public static boolean isBad(int n) {
        if (n >= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }

}
