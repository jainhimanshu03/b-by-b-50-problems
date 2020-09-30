package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

public class Problem5_ConsecutiveArrayTest {

    int[] arr1 = new int[]{4, 2, 1, 6, 5};
    int expResult = 3;
    int[] arr2 = new int[]{5, 5, 3, 1};
    int expResult2 = 1;

    @Test
    public void getMaxLengthOfConsecutive() {
        Assert.assertEquals(expResult, Problem5_ConsecutiveArray.getMaxLengthOfConsecutive(arr1));
        Assert.assertEquals(expResult2, Problem5_ConsecutiveArray.getMaxLengthOfConsecutive(arr2));
    }

    @Test
    public void getMaxLengthOfConsecutive_Optimal() {
        Assert.assertEquals(expResult, Problem5_ConsecutiveArray.getMaxLengthOfConsecutive_Optimal(arr1));
        Assert.assertEquals(expResult2, Problem5_ConsecutiveArray.getMaxLengthOfConsecutive_Optimal(arr2));
    }
}