package com.rv.problems;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ShortedPathUnweightedGraphTest {

    @Test
    public void test1ShortestPath() {
        ShortedPathUnweightedGraph shortedPathUnweightedGraph = new ShortedPathUnweightedGraph();
        int [][]edges = new int[][] {{0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 7}, {3, 7}, {6, 7}, {4, 5}, {4, 6}, {5, 6}};
        Assert.assertEquals(Arrays.asList(0, 3, 7), shortedPathUnweightedGraph.shortestPath(0, 7, edges));
    }

    @Test
    public void test2ShortestPath() {
        ShortedPathUnweightedGraph shortedPathUnweightedGraph = new ShortedPathUnweightedGraph();
        int [][]edges = new int[][] {{0, 1}, {1, 2}, {0, 3}, {3, 4}, {4, 7}, {3, 7}, {6, 7}, {4, 5}, {4, 6}, {5, 6}};
        Assert.assertEquals(Arrays.asList(2, 1, 0, 3, 4, 6), shortedPathUnweightedGraph.shortestPath(2, 6, edges));
    }
}