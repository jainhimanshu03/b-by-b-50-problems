package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

public class Problem3_MatrixProductTest {

    int[][] arr = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    int[][] arr1 = new int[][]{
            {-1, 2, 3},
            {4, 5, -6},
            {7, 8, 9}
    };

    @Test
    public void test_matrixProduct_NonNegative() {
        Problem3_MatrixProduct testClass = new Problem3_MatrixProduct();
        Assert.assertEquals(2016, testClass.matrixProduct_NonNegative(arr));
    }

    @Test
    public void test_matrixProduct_Optimal() {
        Problem3_MatrixProduct testClass = new Problem3_MatrixProduct();
        Assert.assertEquals(1080, testClass.matrixProduct_Optimal(arr1));
    }
}