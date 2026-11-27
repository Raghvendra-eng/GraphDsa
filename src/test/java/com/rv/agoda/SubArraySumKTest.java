package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Input: nums = [1,1,1], k = 2
//Output: 2
//
//Input: nums = [1,2,3], k = 3
//Output: 2
//
//Input: nums = [1,-1,0], k = 0
//Output: 3
//
//Input: nums = [3,4,7,2,-3,1,4,2], k = 7
//Output: 4
//
//Input: nums = [0,0,0,0], k = 0
//Output: 10

class SubArraySumKTest {

    SubArraySumK obj = new SubArraySumK();

    @Test
    public void test(){
        assertEquals(2, obj.solve(new int[]{1,1,1}, 2));
    }

    @Test
    public void test1(){
        assertEquals(2, obj.solve(new int[]{1,2,3}, 3));
    }

    @Test
    public void test2(){
        assertEquals(3, obj.solve(new int[]{1,-1,0}, 0));
    }

    @Test
    public void test3(){
        assertEquals(4, obj.solve(new int[]{3,4,7,2,-3,1,4,2}, 7));
    }

    @Test
    public void test4(){
        assertEquals(10, obj.solve(new int[]{0,0,0,0}, 0));
    }

}