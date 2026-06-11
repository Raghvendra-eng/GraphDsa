package com.rv.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DfsTraversal {

    public List<Integer> DFS(int[][] adj, int start) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        if (adj.length == 0) return ans;

        performDFS(adj, start, ans, visited);
        return ans;
    }

    private void performDFS(int[][] adj, int source, List<Integer> ans, Set<Integer> visited) {
        if (visited.contains(source)) return;
        ans.add(source);
        visited.add(source);
        for (int neighbour: adj[source]) {
            performDFS(adj, neighbour, ans, visited);
        }
    }
}
