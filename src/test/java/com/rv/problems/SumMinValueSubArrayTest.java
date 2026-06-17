package com.rv.problems;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumMinValueSubArrayTest {

    @Test
    public void test1() {
        int []nums = new int[]{3,1,2,4};

        SumMinValueSubArray obj = new SumMinValueSubArray();
        assertEquals(17, obj.minValue(nums));
    }

    @Test
    public void test2() {
        int []nums = new int[]{11,81,94,43,3};

        SumMinValueSubArray obj = new SumMinValueSubArray();
        assertEquals(444, obj.minValue(nums));
    }

    @Test
    public void test3() {
        int []nums = new int[]{2, 2};

        SumMinValueSubArray obj = new SumMinValueSubArray();
        assertEquals(6, obj.minValue(nums));
    }


}