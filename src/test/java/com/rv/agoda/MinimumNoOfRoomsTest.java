package com.rv.agoda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNoOfRoomsTest {

    MinimumNoOfRooms obj = new MinimumNoOfRooms();



//    Input: intervals = [[0,30],[5,10],[15,20]]
//    Output: 2
//
    @Test
    public void test() {
        assertEquals(2, obj.solve(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
//    Input: intervals = [[7,10],[2,4]]
//    Output: 1
//
    @Test
    public void test1() {
        assertEquals(1, obj.solve(new int[][]{{7, 10}, {2, 4}}));
    }
//    Input: intervals = [[1,5],[2,6],[3,7],[4,8]]
//    Output: 4
//
@Test
    public void test2() {
        assertEquals(4, obj.solve(new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}}));
    }
//    Input: intervals = []
//    Output: 0
//
    @Test
    public void test3() {
        assertEquals(0, obj.solve(new int[][]{}));
    }
//    Input: intervals = [[1,2],[2,3],[3,4]]
//    Output: 1
    @Test
    public void test4() {
        assertEquals(1, obj.solve(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }
}