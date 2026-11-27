package com.rv.problems;

import java.util.*;

public class LongestStringArray {

    public String solve(String[] words) {
        if (words.length == 0)
            return "";
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        Set<String> map = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (int index = words.length - 1; index >= 0; index-- ) {
            String str = words[index];
            boolean flag = true;
            for (int end = str.length(); flag && end > 0; end--) {
                String subStr = str.substring(0, end);
                if (!map.contains(subStr)) {
                    flag = false;
                }
            }
            if (flag) {
                if (str.length() >= ans.length())
                ans = str;
                else
                    return ans;
            }
        }
        return ans;
    }

    public int solve2(int[] nums, int k) {
        int start = 0, end = 0, mid;
        for ( int i = 0 ; i < nums.length; i++) {
            end += nums[i];
        }
        int ans = 0;
        while (start <= end) {
            mid = start + (end-start)/2;
            int partition = partitionCount(nums, mid);
            if( partition > k) {
                start = mid + 1;
            } else {
                end = mid -1;
                if (partition == k) {
                    ans= Math.min(ans, mid);
                }
            }
        }
        return ans;
    }

    private int partitionCount(int[] nums, int mid) {
        int sum = 0;
        int partition = 1;

        for ( int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                partition++;
                sum = nums[i];
            }
        }
        return partition;
    }
}
