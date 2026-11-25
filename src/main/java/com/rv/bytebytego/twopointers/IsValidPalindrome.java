package com.rv.bytebytego.twopointers;

import java.util.regex.Pattern;

public class IsValidPalindrome {

    // Best practice for repeated checks
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    public boolean solve(String str) {

        for (int start = 0, end = str.length(); start < end; ) {
            if (!isAlphaNumeric(str.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlphaNumeric(str.charAt(end))) {
                end--;
                continue;
            }
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return ALPHANUMERIC_PATTERN.matcher("" + c).matches();
    }
}
