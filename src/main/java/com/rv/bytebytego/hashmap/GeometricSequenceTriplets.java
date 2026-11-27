package com.rv.bytebytego.hashmap;

import java.util.HashMap;
import java.util.Map;

public class GeometricSequenceTriplets {

    public int solve(int []nums, int r) {

        if ( nums.length == 0) return 0;
        int ans = 0;
        Map<Integer, Integer> rMap = new HashMap<>();
        Map<Integer, Integer> fMap = new HashMap<>();

        for (int x : nums) {
            rMap.put(x, rMap.getOrDefault(x, 0) + 1);
        }
        rMap.put(nums[0], rMap.get(nums[0]) - 1);
        fMap.put(nums[0], 1);
        for ( int i = 1; i < nums.length; i++) {
            if (nums[i]%r == 0) {
                ans += fMap.get(nums[i]/r) * rMap.getOrDefault(nums[i]*r, 0);
            }
            fMap.put(nums[i], fMap.getOrDefault(nums[i], 0) + 1);
            rMap.put(nums[i], rMap.get(nums[i]) - 1);
        }
        return ans;
    }
}
