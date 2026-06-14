package com.rv.problems;

import com.rv.entity.Tree;

public class MaximumPathSum {
    private int ans = Integer.MIN_VALUE;
    public int maxSum(Tree head) {
        if (head == null)   return 0;
        ans = head.val;
        getSum(head);
        return ans;
    }

    private int getSum(Tree head) {
        if (head == null)   return 0;
        int lSum = getSum(head.left);
        int rSum = getSum(head.right);
        int currMax = head.val;
        currMax = Math.max(currMax, currMax + lSum);
        currMax = Math.max(currMax, currMax + rSum);
        ans = Math.max(ans, currMax);
        return Math.max(Math.max(lSum, rSum) + head.val, head.val);
    }

    public MaximumPathSum() {
        this.ans = Integer.MIN_VALUE;
    }
}
