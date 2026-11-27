package com.rv.bytebytego.hashmap;

import java.util.HashSet;
import java.util.Set;

public class LongestChainConsecutiveNo {

    public int solve(int []nums) {
        Set<Integer> set = new HashSet<>();

        for (int no : nums) set.add(no);

        int ans = 0;

        for ( int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int count = 0;
            for (int no = nums[i]; set.contains(no); no++) count++;

            ans = Math.max(ans, count);

        }
        return ans;
    }
}
