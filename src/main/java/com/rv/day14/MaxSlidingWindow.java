package com.rv.day14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int []ans = new int[nums.length - k + 1];
        int index = 0;
        dq.add(0);
        for (int i = 1; i < nums.length; i++) {
            int rIdx = dq.peekLast();

            while ((nums[i] > nums[rIdx]) && !dq.isEmpty()) {
                dq.pollLast();
                rIdx = dq.peekLast();
            }
            dq.add(i);
            int lIdx = dq.peek();
            if (i - lIdx > k)
                dq.poll();
            rIdx = dq.peekLast();
            if (i+1 >= k) {
                ans[index++] =nums[rIdx];
            }
        }
        return ans;
    }
}
