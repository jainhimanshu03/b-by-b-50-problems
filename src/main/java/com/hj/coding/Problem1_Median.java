package com.hj.coding;

public class Problem1_Median {

    public double getMedianFromArrays_Optimzed(int[] a1, int[] a2) {
        if (a1.length > a2.length)
            return getMedianFromArrays_Optimzed(a2, a1);
        int x = a1.length;
        int y = a2.length;
        int start = 0, end = x, partX = 0, partY = 0;
        int commonPart = (x + y + 1) / 2;
        while (start <= end) {
            partX = (start + end) / 2;
            partY = commonPart - partX;

            int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : a1[partX - 1];
            int minRightX = (partX == x) ? Integer.MAX_VALUE : a1[partX];

            int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : a2[partY - 1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : a2[partY];


            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > maxLeftY) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }
        }
        return -1;
    }

    public float getMedianFromArrays_BruteForce(int[] a1, int[] a2) {
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
