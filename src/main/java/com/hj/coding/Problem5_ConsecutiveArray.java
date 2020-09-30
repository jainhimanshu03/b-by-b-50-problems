package com.hj.coding;

import java.util.*;

public class Problem5_ConsecutiveArray {

    public static int getMaxLengthOfConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return 1;

        Set<Integer> hset = new TreeSet<>();
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            hset.add(arr[i]);
        }

        List<Integer> result = new ArrayList<>(hset);
        int count = 1;
        for (int i = 0; i < result.size(); i++) {
            if (i + 1 < result.size() && result.get(i) + 1 == result.get(i + 1)) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return maxCount;
    }

    public static int getMaxLengthOfConsecutive_Optimal(int[] arr) {
        HashSet<Integer> values = new HashSet<>();
        for (int i : arr) {
            values.add(i);
        }
        int maxLength = 0;
        for (int i : values) {
            if (values.contains(i - 1)) continue;
            int length = 0;
            while (values.contains(i++)) length++;
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
