package com.rv.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacter {

    public int solve(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, rem = 0;
        for ( int i = 0; i < str.length(); i++) {
            if ( map.containsKey(str.charAt(i))) {
                int index = map.get(str.charAt(i));
                ans = Math.max(ans, map.size());
                for (int j = rem; j < i; j++) {
                    map.remove(str.charAt(j));
                }
                rem = index + 1;
            }
            map.put(str.charAt(i), i);
        }
        return Math.max(ans, map.size());
    }
}
