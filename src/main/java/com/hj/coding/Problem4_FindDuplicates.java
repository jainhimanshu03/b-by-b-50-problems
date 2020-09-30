package com.hj.coding;

import java.util.*;

public class Problem4_FindDuplicates {

    public static int[] getDuplicates_spaceTradeoff(int[] arr) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hmap.containsKey(arr[i])) {
                hmap.put(arr[i], hmap.get(arr[i]) + 1);
            } else {
                hmap.put(arr[i], 1);
            }
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int key : hmap.keySet()) {
            if (hmap.get(key) > 1) {
                if (!qu.contains(key)) qu.offer(key);
            }
        }

        int[] res = new int[qu.size()];
        int i = 0;
        while (!qu.isEmpty()) {
            res[i++] = qu.poll();
        }

        return res;
    }
    
    public static List<Integer> getDuplicate_Optimal(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = Math.abs(arr[i]);
            int idx = num - 1;
            if (arr[idx] > 0) {
                arr[idx] = -arr[idx];
            } else {
                if (!result.contains(num)) result.add(num);
            }
        }
        return result;
    }


}
