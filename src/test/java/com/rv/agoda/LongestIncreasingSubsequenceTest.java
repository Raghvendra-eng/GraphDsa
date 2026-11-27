package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

//    Input: nums = [10,9,2,5,3,7,101,18]
//    Output: 4

    @Test
    public void test(){
        assertEquals(4, obj.solve(new int[]{10,9,2,5,3,7,101,18}));
    }
//
//    Input: nums = [0,1,0,3,2,3]
//    Output: 4
    @Test
    public void test1(){
        assertEquals(4, obj.solve(new int[]{0,1,0,3,2,3}));
    }
//
//    Input: nums = [7,7,7,7]
//    Output: 1
//
    @Test
    public void test2(){
        assertEquals(1, obj.solve(new int[]{7,7,7,7}));
    }
//    Input: nums = []
//    Output: 0

    @Test
    public void test3(){
        assertEquals(0, obj.solve(new int[]{}));
    }
//
//    Input: nums = [1,2,3,4,5]
//    Output: 5

    @Test
    public void test4(){
        assertEquals(5, obj.solve(new int[]{1,2,3,4,5}));
    }

    @Test
    public void test5(){
        assertEquals(2, obj.solve(new int[]{5, 7, 2, 3}));
    }
}