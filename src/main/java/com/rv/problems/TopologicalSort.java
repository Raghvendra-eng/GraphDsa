package com.rv.problems;

import java.util.*;

public class TopologicalSort {

    public List<Integer> sort(int[][] graph) {
        int node = graph.length;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        if (node == 0)
            return ans;
        boolean[] incomingEdge = new boolean[node];

        for ( int index = 0; index < node; index++)
            incomingEdge[index] = false;

        for (int[] vertices: graph) {
            for (int neighbour: vertices) {
                incomingEdge[neighbour] = true;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int index = 0; index < node; index++) {
            if (!incomingEdge[index]) {
                q.add(index);
                visited.add(index);
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll();
            ans.add(top);
            for (Integer neighbour: graph[top]) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return ans;
    }
}
