package com.rv.bytebytego.hashmap;

import java.util.HashMap;
import java.util.Map;

public class PairSumUnsorted {

    public int[] solve(int []nums, int target) {
        int []ans = new int[]{-1, -1};
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
