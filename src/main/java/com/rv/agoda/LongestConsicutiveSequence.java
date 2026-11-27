package com.rv.agoda;

//Longest Consecutive Sequence
//Find the length of the longest sequence of consecutive integers in an unsorted array.

//Input: nums = [100,4,200,1,3,2]
//Output: 4
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//
//Input: nums = [1,2,0,1]
//Output: 3
//
//Input: nums = []
//Output: 0
//
//Input: nums = [10]
//Output: 1

import java.util.HashSet;
import java.util.Set;

public class LongestConsicutiveSequence {
    public int solve(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int ans = 0;

        for (int num: nums) {
            if (set.contains(num-1)) {
                continue;
            }
            int count = 0;
            while (set.contains(num)) {
                count++;
                set.remove(num);
                num++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
