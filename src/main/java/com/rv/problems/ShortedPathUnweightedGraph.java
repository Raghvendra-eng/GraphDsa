package com.rv.problems;

import java.util.*;

public class ShortedPathUnweightedGraph {

    public List<Integer> shortestPath(int source, int destination, int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<Integer>());
            graph.putIfAbsent(edge[1], new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(source, -1);
        prev.put(destination, -1);
        bfs(graph, source, destination, prev);

        List<Integer> ans = new ArrayList<>();

        if (prev.get(destination) == -1) return ans;
        ans.add(destination);
        int curr = prev.get(destination);
        while (curr != source) {
            ans.add(curr);
            curr = prev.get(curr);
        }
        ans.add(source);
        Collections.reverse(ans);
        return ans;
    }

    private void bfs(Map<Integer, List<Integer>> graph, int source, int destination, Map<Integer, Integer> prev) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q= new ArrayDeque<>();
        q.add(source);
        visited.add(source);
        while(!q.isEmpty()) {
            int curr = q.poll();

            for (Integer neighbour: graph.get(curr)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(neighbour);
                    prev.put(neighbour, curr);
                }
                if (neighbour == destination) return;
            }
        }
    }
}
