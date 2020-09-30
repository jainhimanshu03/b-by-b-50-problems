package com.hj.coding;

public class Problem3_MatrixProduct {

    //for non-negative integers in matrix
    public int matrixProduct_NonNegative(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int i = 0, j = 0, maxProduct = arr[0][0];
        while (i < n && j < m) {
            int right = Integer.MIN_VALUE;
            int bottom = Integer.MIN_VALUE;
            if (i + 1 < n) bottom = maxProduct * arr[i + 1][j];
            if (j + 1 < m) right = maxProduct * arr[i][j + 1];
            if (right > bottom) {
                maxProduct = right;
                j++;
            } else {
                maxProduct = bottom;
                i++;
            }
            if (i == n - 1 && j == m - 1) {
                break;
            }
        }
        return maxProduct;
    }

    //    [-1, 2, 3]
//    [4, 5, -6]
//    [7, 8, 9]
//    max_cache
//    [-1, -2, -6]
//    [-4, -10, 120]
//    [-28, -80, 1080]
//
//    min_cache
//    [-1, -2, -6]
//    [-4, -20, 36]
//    [-28, -224, -2016]
//
    public int matrixProduct_Optimal(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) return 0;
        int[][] max_cache = new int[arr.length][arr[0].length];
        int[][] min_cache = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int maxValue = Integer.MIN_VALUE;
                int minValue = Integer.MAX_VALUE;
                if (i == 0 && j == 0) {
                    max_cache[i][j] = arr[i][j];
                    min_cache[i][j] = arr[i][j];
                }

                if (i > 0) {
                    int tempMax = Math.max(arr[i][j] * max_cache[i - 1][j], arr[i][j] * min_cache[i - 1][j]);
                    maxValue = Math.max(maxValue, tempMax);
                    int tempMin = Math.min(arr[i][j] * max_cache[i - 1][j], arr[i][j] * min_cache[i - 1][j]);
                    minValue = Math.min(minValue, tempMin);
                }

                if (j > 0) {
                    int tempMax = Math.max(arr[i][j] * max_cache[i][j - 1], arr[i][j] * min_cache[i][j - 1]);
                    maxValue = Math.max(maxValue, tempMax);
                    int tempMin = Math.min(arr[i][j] * max_cache[i][j - 1], arr[i][j] * min_cache[i][j - 1]);
                    minValue = Math.min(minValue, tempMin);
                }

                max_cache[i][j] = maxValue;
                min_cache[i][j] = minValue;

            }
        }
        return max_cache[arr.length - 1][arr[0].length - 1];
    }
}
