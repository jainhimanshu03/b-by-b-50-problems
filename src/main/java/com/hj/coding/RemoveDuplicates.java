package com.hj.coding;

import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(int[] arr) {
        List<Integer> myList = new ArrayList<>();
        Set<Integer> myset = new HashSet<>();
        myset.add(arr[0]);
        myList.add(arr[0]);
        int j = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i + 1];
            if (!myset.contains(val)) {
                myList.add(val);
                j++;
                myset.add(val);
            }
        }
        return myList;
    }

    private static int[] removeDup(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]))
                continue;
            q.offer(arr[i]);
            set.add(arr[i]);
        }
        int[] res = new int[q.size()];
        int cnt = 0;
        while (!q.isEmpty()) {
            res[cnt++] = q.poll();
        }
        return res;
    }
}
