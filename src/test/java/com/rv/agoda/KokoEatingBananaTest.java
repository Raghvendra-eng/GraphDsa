package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananaTest {

    KokoEatingBanana obj = new KokoEatingBanana();

//    Input: piles = [3,6,7,11], h = 8
//    Output: 4
    @Test
    public void test(){
        assertEquals(4, obj.solve(new int[]{3,6,7,11}, 8));
    }
//    Input: piles = [30,11,23,4,20], h = 5
//    Output: 30
    @Test
    public void test1(){
        assertEquals(30, obj.solve(new int[]{30,11,23,4,20}, 5));
    }
//    Input: piles = [30,11,23,4,20], h = 6
//    Output: 23
    @Test
    public void test2(){
        assertEquals(23, obj.solve(new int[]{30,11,23,4,20}, 6));
    }
//    Input: piles = [1], h = 1
//    Output: 1
    @Test
    public void test3(){
        assertEquals(1, obj.solve(new int[]{1}, 1));
    }
//    Input: piles = [312884470], h = 968709470
//    Output: 1
    @Test
    public void test4(){
        assertEquals(1, obj.solve(new int[]{312884470}, 968709470));
    }
}