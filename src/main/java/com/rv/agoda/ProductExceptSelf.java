package com.rv.agoda;

//Product of Array Except Self
//Return an array where each element is the product of all other elements, without using division.

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] solve(int []nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        int prod = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            ans[i] = ans[i] * prod;
            prod *= nums[i];
        }

        return ans;
    }
}
