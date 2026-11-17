package com.rv.agoda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class TopKFrequentElementTest {

    TopKFrequentElement obj = new TopKFrequentElement();
    //    Input: nums = [1,1,1,2,2,3], k = 2
    //    Output: [1,2]
    @Test
    public void test() {

        List<Integer> ans = obj.solve(new int[]{1,1,1,2,2,3}, 2);
        Collections.sort(ans);
        List<Integer> expected = Arrays.asList(1, 2);
        Collections.sort(expected);
        assertEquals(expected.size(), ans.size());

        assertEquals(true, expected.equals(ans));
    }

//
//    Input: nums = [1], k = 1
//    Output: [1]
    @Test
    public void test1() {

        List<Integer> ans = obj.solve(new int[]{1}, 1);
        Collections.sort(ans);
        List<Integer> expected = Arrays.asList(1);
        Collections.sort(expected);
        assertEquals(expected.size(), ans.size());

        assertEquals(true, expected.equals(ans));
    }
//
//    Input: nums = [4,4,4,5,5,6,6,6,6], k = 2
//    Output: [6,4]
    @Test
    public void test2() {

        List<Integer> ans = obj.solve(new int[]{4,4,4,5,5,6,6,6,6}, 2);
        Collections.sort(ans);
        List<Integer> expected = Arrays.asList(6, 4);
        Collections.sort(expected);
        assertEquals(expected.size(), ans.size());

        assertEquals(true, expected.equals(ans));
    }
//
//    Input: nums = [-1,-1,-2,-2,-2,3], k = 2
//    Output: [-2,-1]

    @Test
    public void test3() {

        List<Integer> ans = obj.solve(new int[]{-1,-1,-2,-2,-2,3}, 2);
        Collections.sort(ans);
        List<Integer> expected = Arrays.asList(-1, -2);
        Collections.sort(expected);
        assertEquals(expected.size(), ans.size());

        assertEquals(true, expected.equals(ans));
    }
}