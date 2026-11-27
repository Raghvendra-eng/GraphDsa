package com.rv.agoda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
//
//Input: nums = [2,3]
//Output: [3,2]
//
//Input: nums = [0,0]
//Output: [0,0]
class ProductExceptSelfTest {
    ProductExceptSelf obj = new ProductExceptSelf();
    @Test
    public void test() {
        assertEquals(true, Arrays.equals(new int[]{24,12,8,6}, obj.solve(new int[]{1,2,3,4})));
    }

    @Test
    public void test1() {
        assertEquals(true, Arrays.equals(new int[]{0,0,9,0,0}, obj.solve(new int[]{-1,1,0,-3,3})));
    }

    @Test
    public void test2() {
        assertEquals(true, Arrays.equals(new int[]{3,2}, obj.solve(new int[]{2,3})));
    }

    @Test
    public void test3() {
        assertEquals(true, Arrays.equals(new int[]{0,0}, obj.solve(new int[]{0,0})));
    }

}