package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Input: s = "abcabcbb"
//Output: 3
//
//Input: s = "bbbbb"
//Output: 1
//
//Input: s = "pwwkew"
//Output: 3
//
//Input: s = ""
//Output: 0
//
//Input: s = "dvdf"
//Output: 3
class LongestSubstringWithoutRepeatTest {

    LongestSubstringWithoutRepeat obj = new LongestSubstringWithoutRepeat();

    @Test
    public void test1() {
        assertEquals(3, obj.solve("abcabcbb"));
    }

    @Test
    public void test2() {
        assertEquals(1, obj.solve("bbbbb"));
    }

    @Test
    public void test3() {
        assertEquals(3, obj.solve("pwwkew"));
    }

    @Test
    public void test4() {
        assertEquals(3, obj.solve("dvdf"));
    }

    @Test
    public void test5() {
        assertEquals(5, obj.solve("abcde"));
    }

    @Test
    public void test6() {
        assertEquals(0, obj.solve(""));
    }

}