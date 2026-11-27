package com.rv.bytebytego.twopointers;

public class PairSum {

    public int[] solve(int []nums, int target) {
        int len = nums.length;
        int []ans = new int[]{-1, -1};
        for (int i = 0, j = len -1; j > i; ) {
            if ((nums[i] + nums[j]) == target) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }

            if ((nums[i] + nums[j]) < target)   i++;
            else j--;
        }
        return ans;
    }
}
