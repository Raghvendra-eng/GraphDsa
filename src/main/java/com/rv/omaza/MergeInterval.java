package com.rv.omaza;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//Example 1:
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//        Example 3:
//Input: intervals = [[4,7],[1,4]]
//Output: [[1,7]]
//Explanation: Intervals [1,4] and [4,7] are considered overlapping.
public class MergeInterval {

    public List<List<Integer>> solve(int[][]intevals) {

        int len = intevals.length;

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intevals, (a, b) -> a[0] - b[0]);
        ans.add(Arrays.asList(intevals[0][0], intevals[0][1]));

        for ( int i = 1; i < len; i++) {
            if (isOverlapping(ans.get(ans.size() - 1).get(1), intevals[i][0])) {
                List<Integer> arr = ans.get(ans.size() - 1);
                arr.set(1, Math.max(arr.get(1), intevals[i][1]));
            } else {
                ans.add(Arrays.asList(intevals[i][0], intevals[i][1]));
            }

        }
        return ans;

    }

    private boolean isOverlapping(Integer integer, int i) {
        return integer >= i;
    }
}
