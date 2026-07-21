package com.rv.day13;

import java.util.*;

public class TripletSumZero {

    public int[][] solve(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        int len = nums.length;
        for ( int index = 0; index < len; index++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int itr = index + 1; itr < len; itr++) {
                if (map.containsKey(0 - nums[index] - nums[itr])) {
                    List<Integer> entry = Arrays.asList(nums[index], nums[map.get(-nums[index] - nums[itr])], nums[itr]);
                    Collections.sort(entry);
                    ans.add(entry);
                }
                map.put(nums[itr], itr);
            }
        }
        return ans.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
