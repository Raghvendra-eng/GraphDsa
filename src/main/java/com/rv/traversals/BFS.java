package com.rv.traversals;

import java.util.*;

public class BFS {

    public BFS() {
        this.visited = new HashSet<>();
    }

    private static Set<Integer> visited;

    public void bfsTraversal(List<List<Integer>> graph, Integer source) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            System.out.print(curr + " --> ");

            List<Integer> neighbours = graph.get(curr);
            for(Integer neighbour: neighbours) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

    }
}
