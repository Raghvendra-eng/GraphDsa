package com.rv.paytm;

/*
A string consisting of uppercase english characters can be encoded to a number using the following mapping:
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode a message, digits must be grouped and then mapped back into letters using the reverse of the mapping above. There may be multiple ways to decode a message. For example, "1012" can be mapped into:
"JAB" with the grouping (10 1 2)
"JL" with the grouping (10 12)
The grouping (1 01 2) is invalid because 01 cannot be mapped into a letter since it contains a leading zero.
Given a string s containing only digits, return the number of ways to decode it. You can assume that the answer fits in a 32-bit integer.
 */

// 1012
//ans[i-1] + ans[i-2]
public class Question2 {

    public int solve(String str) {

        if (str.length() == 0) return 0;
        int[] ans = new int[str.length()+1];
        ans[0] = 1;
        ans[1] = 1;

        for(int start = 2; start <= str.length(); start++) {
            if(str.charAt(start-1) == '0') {
                ans[start] = ans[start-1];
                continue;
            }
            int value = Integer.parseInt("" + str.charAt(start-1) + str.charAt(start-2));
            if (value == 0) return 0;
            if ( value >= 11 & value <= 26) {
                ans[start] = ans[start-1] + ans[start-2];
            } else {
                ans[start] = ans[start-1];
            }
        }
        return ans[str.length()];
    }
}
