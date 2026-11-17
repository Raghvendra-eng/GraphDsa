package com.rv.agoda;

public class LongestIncreasingSubsequence {

    public int solve(int []nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int []lis = new int[len];
        lis[0] = 1;
        longestIncSubseq(nums, lis, len-1);
        int ans = 0;

        for (int num: lis) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    private void longestIncSubseq(int[] nums, int[] lis, int i) {
        if (lis[i] != 0) {
            return;
        }
        for (int j = i-1; j > 0; j--) {
            longestIncSubseq(nums, lis, j);

            lis[i] = Math.max(lis[i], lis[j] + (nums[j] < nums[i] ? 1 : 0));
        }
    }
}
