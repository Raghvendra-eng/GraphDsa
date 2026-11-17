package com.rv.agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public int[][] solve(int [][]intervals) {
        List<int[]> ans = new ArrayList<>();
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ans.add(intervals[0]);

        for ( int i = 1; i < intervals.length; i++) {
            if (isOverlapping(ans.get(ans.size() - 1), intervals[i])) {
                int []curr = ans.get(ans.size() - 1);
                curr[1] = Math.max(curr[1], intervals[i][1]);
                ans.set(ans.size() - 1, curr);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(int[][]::new);
    }

    private boolean isOverlapping(int[] ints, int[] interval) {
        return ints[1] >= interval[0];
    }
}
