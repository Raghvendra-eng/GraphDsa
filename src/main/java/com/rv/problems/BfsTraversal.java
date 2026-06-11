package com.rv.problems;

import java.util.*;

public class BfsTraversal {

    public List<Integer> BFS (int[][] adj, int start) {
        List<Integer> ans = new ArrayList<>();
        if (adj.length == 0) return ans;
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);

        while(!q.isEmpty()) {
            int current = q.poll();
            ans.add(current);
            for (int neighbour: adj[current]) {
                if (!visited.contains(neighbour)) {
                    q.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
        return ans;
    }
}
