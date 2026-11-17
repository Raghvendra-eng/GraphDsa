package com.rv.agoda;

//Given an integer array and k, count the number of contiguous subarrays whose sum equals k.

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

import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {

    public int solve(int[] nums, int reqSum) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num: nums) {
            sum += num;
            int count = map.getOrDefault(sum - reqSum, 0);
            ans += count;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
