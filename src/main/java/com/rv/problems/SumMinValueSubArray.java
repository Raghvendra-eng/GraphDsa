package com.rv.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumMinValueSubArray {

    public int minValue(int[] nums) {
        long ans = 0;
        int n = nums.length;

        if (n == 0) return 0;

        if (n == 1) return nums[0];
        int[] left, right;
        left = new int[nums.length];
        right = new int[nums.length];

        for( int index = 0; index < nums.length; index++) {
            left[index] = -1;
        }

        for( int index = 0; index < nums.length; index++) {
            right[index] = nums.length;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for ( int index = 1; index < n; index++) {
            if (nums[stack.peek()] <= nums[index]) {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] > nums[index]) {
                    int sTop = stack.pop();
                    right[sTop] = index;
                }
                stack.push(index);
            }
        }
        stack.clear();
        stack.push(n-1);
        for ( int index = n-2; index >= 0; index--) {
            if (nums[stack.peek()] < nums[index]) {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[index]) {
                    int sTop = stack.pop();
                    left[sTop] = index;
                }
                stack.push(index);
            }
        }
        int mod = 1000000007;
        for ( int index = 0; index < n; index++) {
            ans = ans + (((nums[index])%mod*(right[index] - index))%mod*(index - left[index]))%mod;
            ans = ans%mod;
        }
        return (int)ans;
    }
}
