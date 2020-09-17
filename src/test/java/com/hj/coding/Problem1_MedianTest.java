package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

public class Problem1_MedianTest {

    int[] input_arr1 = new int[]{
            1, 3, 5
    };
    int[] input_arr2 = new int[]{
            2, 4, 6
    };
    int[] input_arr3 = new int[]{
            -5, 3, 6, 12, 15
    };
    int[] input_arr4 = new int[]{
            -12, -10, -6, -3, 4, 10
    };

    int[] input_arr5 = new int[]{
            2, 3, 5, 8
    };
    int[] input_arr6 = new int[]{
            10, 12, 14, 16, 18, 20
    };

    @Test
    public void test_getMedianFromArrays_BruteForce() {
        Problem1_Median testClass = new Problem1_Median();
        float expected = 3.5f;
        Assert.assertEquals(expected, testClass.getMedianFromArrays_BruteForce(input_arr1, input_arr2), 0);
        Assert.assertEquals(3, testClass.getMedianFromArrays_BruteForce(input_arr3, input_arr4), 0);
        Assert.assertEquals(11, testClass.getMedianFromArrays_BruteForce(input_arr5, input_arr6), 0);
    }

    @Test
    public void test_getMedianFromArrays_Optimzed() {
        Problem1_Median testClass = new Problem1_Median();
        float expected = 3.5f;
        Assert.assertEquals(expected, testClass.getMedianFromArrays_Optimzed(input_arr1, input_arr2), 0);
        Assert.assertEquals(3, testClass.getMedianFromArrays_Optimzed(input_arr3, input_arr4), 0);
        Assert.assertEquals(11, testClass.getMedianFromArrays_Optimzed(input_arr5, input_arr6), 0);
    }
}