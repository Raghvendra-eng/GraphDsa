package com.rv.agoda;

import java.util.Arrays;
import java.util.Stack;

public class DaysForWarmerTemperature {

    public int[] solve(int []temparatures) {
        int []ans = new int[temparatures.length];
        int n = temparatures.length;
        Arrays.fill(ans, 0);
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);

        for (int index = n-2; index >= 0; index--) {
            while (!stack.isEmpty() && temparatures[index] >= temparatures[stack.peek()]) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[index] = stack.peek() - index;
            }
            stack.push(index);
        }
        return ans;
    }
}
