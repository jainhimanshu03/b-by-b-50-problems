package com.hj.coding;

public class Problem1_Median {

    public float getMedianFromArrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int[] mergeArr = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (i < n && a1[i] <= a2[j]) {
                mergeArr[k++] = a1[i++];
            } else if (j < m && a1[i] >= a2[j]) {
                mergeArr[k++] = a2[j++];
            }
        }
        while (i < n && k < n + m) {
            mergeArr[k++] = a1[i++];
        }

        while (j < m && k < n + m) {
            mergeArr[k++] = a2[j++];
        }
        float median = 0;
        int s = n + m;
        if (s % 2 != 0) {
            median = mergeArr[s / 2];
        } else {
            median = (mergeArr[s / 2] + mergeArr[(s / 2) - 1]) / 2f;
        }

        return median;
    }
}
