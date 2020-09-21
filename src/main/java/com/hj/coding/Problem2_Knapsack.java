package com.hj.coding;

import java.util.ArrayList;
import java.util.List;

public class Problem2_Knapsack {

    //Return list of weight contributing to maxWeight profit
    public List<Integer> getKnapsackReturnWeights_Iterative(int[] w, int[] p, int maxWeight) {
        int n = w.length;
        int m = maxWeight;
        int[][] arr = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    arr[i][j] = Math.max(arr[i - 1][j], p[i - 1] + arr[i - 1][j - w[i - 1]]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (arr[i][j] == 0) break;
            else if (arr[i][j] == arr[i - 1][j]) i--;
            else {
                result.add(w[i - 1]);
                i--;
                j = j - w[i - 1] - 1;
            }
        }
        return result;
    }

    //Return maxProfit possible utilizing the weights in knapsack
    public int getKnapsack_Iterative(int[] w, int[] p, int maxWeight) {
        int n = w.length;
        int m = maxWeight;
        int[][] arr = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    arr[i][j] = Math.max(arr[i - 1][j], p[i - 1] + arr[i - 1][j - w[i - 1]]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        return arr[n][m];
    }

    // Knapsack Recursive Solution
    public int getKnapsack_Recursion(int[] w, int[] p, int maxWeight, int n) {
        //Base case for termination for recursion
        if (n == 0 || maxWeight == 0) return 0;

        if (w[n - 1] > maxWeight) {
            return getKnapsack_Recursion(w, p, maxWeight, n - 1);
        } else {
            return Math.max(p[n - 1] + getKnapsack_Recursion(w, p, maxWeight - w[n - 1], n - 1), getKnapsack_Recursion(w, p, maxWeight, n - 1));
        }
    }

    // Knapsack Recursive Solution with DP and Memoization

    public int getKnapsack_Recursion_Memo(int[] w, int[] p, int m, int n, int[][] dp) {
        //Base case for termination for recursion
        if (n == 0 || m == 0) return 0;

        if (dp[n - 1][m - 1] != -1) {
            return dp[n - 1][m - 1];
        }

        if (w[n - 1] > m) {
            return dp[n - 1][m - 1] = getKnapsack_Recursion(w, p, m, n - 1);
        } else {
            return dp[n - 1][m - 1] = Math.max(p[n - 1] + getKnapsack_Recursion(w, p, m - w[n - 1], n - 1), getKnapsack_Recursion(w, p, m, n - 1));
        }
    }

    public void memset(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }
    }
}
