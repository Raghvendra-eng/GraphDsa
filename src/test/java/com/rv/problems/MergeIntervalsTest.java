package com.rv.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalsTest {

    @Test
    public void test1() {
        MergeIntervals obj = new MergeIntervals();

        int[][] input = new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18},
        };

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1, 6));
        ans.add(Arrays.asList(8, 10));
        ans.add(Arrays.asList(15, 18));

        assertEquals( ans, obj.solve(input));
    }
}