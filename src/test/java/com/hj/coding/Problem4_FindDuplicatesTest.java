package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Problem4_FindDuplicatesTest {

    int[] arr = new int[]{1, 2, 2};
    int[] expArr = new int[]{2};
    int[] arr1 = new int[]{1, 2, 1, 2};
    int[] expArr1 = new int[]{1, 2};
    int[] arr3 = new int[]{3, 3, 3};
    int[] expArr3 = new int[]{3};
    int[] arr2 = new int[]{1, 2, 3};
    int[] expArr2 = new int[]{};

    @Test
    public void test_getDuplicates() {
        Assert.assertTrue(compareArr(Problem4_FindDuplicates.getDuplicates_spaceTradeoff(arr), expArr));
        Assert.assertTrue(compareArr(Problem4_FindDuplicates.getDuplicates_spaceTradeoff(arr1), expArr1));
        Assert.assertTrue(compareArr(Problem4_FindDuplicates.getDuplicates_spaceTradeoff(arr3), expArr3));
        Assert.assertTrue(compareArr(Problem4_FindDuplicates.getDuplicates_spaceTradeoff(arr2), expArr2));
    }


    @Test
    public void test_getDuplicates_Optimal() {
        Assert.assertTrue(compareList(Problem4_FindDuplicates.getDuplicate_Optimal(arr), expArr));
        Assert.assertTrue(compareList(Problem4_FindDuplicates.getDuplicate_Optimal(arr1), expArr1));
        Assert.assertTrue(compareList(Problem4_FindDuplicates.getDuplicate_Optimal(arr3), expArr3));
        Assert.assertTrue(compareList(Problem4_FindDuplicates.getDuplicate_Optimal(arr2), expArr2));
    }

    private boolean compareArr(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }

        return true;
    }

    private boolean compareList(List<Integer> a1, int[] a2) {
        for (int i = 0; i < a1.size(); i++) {
            if (a1.get(i) != a2[i]) return false;
        }
        return true;
    }

}