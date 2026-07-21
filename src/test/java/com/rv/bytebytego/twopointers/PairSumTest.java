package com.rv.bytebytego.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PairSumTest {

    @Test
    public void test1(){
        int []nums = new int[]{-5, -2, 3, 4, 6};
        int target = 7;

        PairSum obj = new PairSum();
        int []ans = obj.solve(nums, target);
        assertEquals(target, nums[ans[0]] + nums[ans[1]]);
    }

    @Test
    public void test2(){
        int []nums = new int[]{1, 1, 1};
        int target = 2;

        PairSum obj = new PairSum();
        int []ans = obj.solve(nums, target);
        assertEquals(target, nums[ans[0]] + nums[ans[1]]);
    }
}