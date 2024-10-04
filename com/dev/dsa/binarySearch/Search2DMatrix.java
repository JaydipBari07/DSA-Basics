package com.dev.dsa.binarySearch;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, col = 0;
        if (rows != 0) {
            col = matrix[0].length;
        }
        if (rows == 0 || col == 0) {
            return false;
        }
        int size = rows * col;      //find total length
        int start = 0, end = size - 1;
        while (start <= end) {
            int mid = (start + end) / 2;    //find mid index
            int r = mid / col, c = mid % col;   // calculate exact row x col to locate the mid indexed value
            if (matrix[r][c] > target) {
                end = mid - 1;
            } else if (matrix[r][c] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int mid = (8 + 8) / 2;
//        System.out.println("mid: " + mid);
//        System.out.println(mid % 3);
//        System.out.println(mid / 3);
        System.out.println(searchMatrix(mat, 10));
    }
}
