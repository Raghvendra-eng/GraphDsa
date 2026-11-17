package com.rv.agoda;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

    public int solve(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, rem = 0;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                ans = Math.max(ans, i - map.get(ch));
                int index = map.get(ch);
                for (int j = rem; j <= index; j++) {
                    map.remove(str.charAt(j));
                }
                rem = index + 1;
            }
            map.put(ch, i);
            ans = Math.max(ans, map.size());
        }
        ans = Math.max(ans, map.size());
        return ans;
    }
}
