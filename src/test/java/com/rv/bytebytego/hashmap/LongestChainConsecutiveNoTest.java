package com.rv.bytebytego.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestChainConsecutiveNoTest {

    LongestChainConsecutiveNo obj = new LongestChainConsecutiveNo();
    @Test
    void test() {
        assertEquals(4, obj.solve(new int[]{1, 6, 2, 5, 8, 7, 10, 3}));
        assertEquals(4, obj.solve(new int[]{100,4,200,1,3,2}));
        assertEquals(9, obj.solve(new int[]{0,3,7,2,5,8,4,6,0,1}));
        assertEquals(3, obj.solve(new int[]{1,0,1,2}));
    }
}