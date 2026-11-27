package com.rv.agoda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//
//Input: intervals = [[5,7],[1,3],[2,6],[10,12]]
//Output: [[1,7],[10,12]]
//
//Input: intervals = [[1,10],[2,3],[4,8]]
//Output: [[1,10]]
class MergeIntervalTest {
    MergeInterval obj = new MergeInterval();

    @Test
    public void test() {
        int [][] expected = new int[][] {
                {1, 6}, {8, 10}, {15, 18}
        };

        int [][] output = obj.solve(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        assertEquals(expected.length, output.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(true, Arrays.equals(expected[i], output[i]));
        }
    }

    @Test
    public void test1() {
        int [][] expected = new int[][] {{1,5}};

        int [][] output = obj.solve(new int[][]{{1, 4},{4, 5}});

        assertEquals(expected.length, output.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(true, Arrays.equals(expected[i], output[i]));
        }
    }

    @Test
    public void test2() {
        int [][] expected = new int[][] {{1, 7}, {10, 12}};

        int [][] output = obj.solve(new int[][]{{5, 7}, {1, 3}, {2, 6}, {10, 12}});

        assertEquals(expected.length, output.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(true, Arrays.equals(expected[i], output[i]));
        }
    }

    //
    //Input: intervals = [[1,10],[2,3],[4,8]]
    //Output: [[1,10]]

    @Test
    public void test3() {
        int [][] expected = new int[][] {{1, 10}};

        int [][] output = obj.solve(new int[][]{{1, 10}, {2, 3}, {4, 8}});

        assertEquals(expected.length, output.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(true, Arrays.equals(expected[i], output[i]));
        }
    }
}