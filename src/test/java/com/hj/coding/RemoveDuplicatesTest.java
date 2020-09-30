package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesTest {

    int[] arr = new int[]
            {
                    3, 7, 5, 5, 7, 1, 2
            };

    @Test
    public void test_removeDuplicates() {
        int[] expectedArr = new int[]{3, 7, 5, 1, 2};
        List<Integer> arrlist = new ArrayList<>();
        arrlist.add(3);
        arrlist.add(7);
        arrlist.add(5);
        arrlist.add(1);
        arrlist.add(2);
        Assert.assertTrue(isSame(arrlist, RemoveDuplicates.removeDuplicates(arr)));
    }

    private boolean isSame(List<Integer> arrlist, List<Integer> removeDuplicates) {
        for (int i = 0; i < removeDuplicates.size(); i++) {
            if (arrlist.get(i) != removeDuplicates.get(i)) return false;
        }
        return true;
    }
}