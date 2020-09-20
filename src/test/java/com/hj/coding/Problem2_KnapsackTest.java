package com.hj.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Problem2_KnapsackTest {

    int[] p = new int[]{
            1, 2, 5, 6
    };
    int[] w = new int[]{
            2, 3, 4, 5
    };

    int[] p1 = new int[]{
            6, 10, 12
    };
    int[] w1 = new int[]{
            1, 2, 3
    };

    @Test
    public void test_getKnapsack_Iterative() {
        Problem2_Knapsack testClass = new Problem2_Knapsack();
        Assert.assertEquals(8, testClass.getKnapsack_Iterative(w, p, 8));
        Assert.assertEquals(22, testClass.getKnapsack_Iterative(w1, p1, 5));
    }

    @Test
    public void test_getKnapsackReturnWeights_Iterative() {
        Problem2_Knapsack testClass = new Problem2_Knapsack();
        List<Integer> expResult = new ArrayList<>();
        expResult.add(5);
        expResult.add(3);
        List<Integer> expResult1 = new ArrayList<>();
        expResult1.add(3);
        expResult1.add(2);
        Assert.assertEquals(expResult, testClass.getKnapsackReturnWeights_Iterative(w, p, 8));
        Assert.assertEquals(expResult1, testClass.getKnapsackReturnWeights_Iterative(w1, p1, 5));
    }
}