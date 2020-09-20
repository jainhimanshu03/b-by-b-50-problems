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
}
