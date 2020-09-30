package com.hj.coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
