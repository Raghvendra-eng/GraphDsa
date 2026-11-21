package com.rv.paytm;

/*

Given a binary array nums and an integer k,
return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

[1,1,1,0,0,0,1,1,1,1,0], k = 2
len = n; len >= 0; l--
start = 0 start+len <= n
end = start + end -
[0,0,0,1,2,3,3,3,]
 */
public class Question {

    public int solve(int []nums, int k) {
        int countZero = 0, ans = 0;
        for (int start= 0, end = 0; end < nums.length; end++) {  // [1,1,1,0,0,0,1,1,1,1,0], k = 2
            if (nums[end] == 0) {
                countZero++;
            }
            while (start < end && countZero > k) {
                    if (nums[start] == 0) {
                        countZero--;
                    }
                    start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
