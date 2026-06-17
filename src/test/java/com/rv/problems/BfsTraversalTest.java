package com.rv.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BfsTraversalTest {

    @Test
    public void testBFS() {
        int[][] adj = {
                {1, 2},
                {0, 2},
                {0, 1, 3, 4},
                {2},
                {2},
        };
        BfsTraversal bfsTraversal = new BfsTraversal();
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), bfsTraversal.BFS(adj, 0));
    }

}