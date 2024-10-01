package com.dev.dsa.binarySearch.rangeSearch;

public class GuessTheNumber {

    static int guessedNum = 1702766719; // This is the number guessed by user.

    public static int guessNumber(int n) {
        int start = 0, end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;                // Here we have to do divide the difference by 2 as it is efficient than dividing their addition by 2. It gives timeout for the later case.
            if (guess(mid) == 1) {
                start = mid + 1;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int guess(int num) {
        if (num < guessedNum) {
            return 1;
        } else if (num > guessedNum) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }
}
