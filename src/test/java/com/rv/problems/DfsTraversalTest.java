package com.rv.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DfsTraversalTest {

    @Test
    public void testDFS() {
        int[][] adj = {
                {1, 2},
                {0, 2},
                {0, 1, 3, 4},
                {2},
                {2},
        };
        DfsTraversal dfsTraversal = new DfsTraversal();
        Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4), dfsTraversal.DFS(adj, 0));
    }

    @Test
    public void testDFS2() {
        int[][] adj = {
                {1, 2},
                {0, 2},
                {0, 1, 3, 4},
                {2},
                {2},
        };
        DfsTraversal dfsTraversal = new DfsTraversal();
        Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4), dfsTraversal.DFS(adj, 0));
    }
}