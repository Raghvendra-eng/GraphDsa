package com.rv.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public List<List<Integer>> solve(int[][] intervals) {
        int len = intervals.length;

        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        Arrays.sort(intervals, (first, second) -> {
            return (first[0] - second[0]);
        });
        ans.add(Arrays.asList(intervals[0][0], intervals[0][1]));

        for (int index = 1; index < len; index++) {
            int ansLen = ans.size();
            if(isOverlapping(ans.get(ansLen - 1).get(1), intervals[index][0])) {
                List<Integer> curr = ans.get(ansLen - 1);
                curr.set(1, Math.max(curr.get(1), intervals[index][1]));
                ans.set(ansLen - 1, curr);
            } else {
                ans.add(Arrays.asList(intervals[index][0], intervals[index][1]));
            }
        }
        return ans;
    }


    private boolean isOverlapping(int preEnd, int nextStart) {
        return preEnd >= nextStart;
    }
}
