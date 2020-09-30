package com.hj.coding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
}
