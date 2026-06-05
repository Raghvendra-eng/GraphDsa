package com.rv.traversals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {

    public DFS() {
        this.visited = new HashSet<>();
    }

    private static Set<Integer> visited;

    public void dfsTraversal(List<List<Integer>> graph, Integer source) {
        if (visited.contains(source)) {
            return;
        }
        List<Integer> neighbours = graph.get(source);
        System.out.print(source + " --> ");
        visited.add(source);
        for (Integer neighbour: neighbours) {
            dfsTraversal(graph, neighbour);
        }
    }
}
