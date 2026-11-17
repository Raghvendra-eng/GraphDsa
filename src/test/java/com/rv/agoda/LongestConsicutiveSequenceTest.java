package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsicutiveSequenceTest {
    LongestConsicutiveSequence obj = new LongestConsicutiveSequence();

    @Test
    public void test() {
        assertEquals(4, obj.solve(new int[]{100,4,200,1,3,2}));
    }

    @Test
    public void test1() {
        assertEquals(9, obj.solve(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    @Test
    public void test2() {
        assertEquals(3, obj.solve(new int[]{1,2,0,1}));
    }

    @Test
    public void test3() {
        assertEquals(0, obj.solve(new int[]{}));
    }

    @Test
    public void test4() {
        assertEquals(1, obj.solve(new int[]{1}));
    }
}