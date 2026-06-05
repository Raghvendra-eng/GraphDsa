package com.rv.representation;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    public static List<List<Integer>> createUndirectedAdjacencyList(int[][] edges, int node) {
        List<List<Integer>> graph = new ArrayList<>();
        // Initialization of each index
        for (int index = 0; index < node; index++) {
            graph.add(new ArrayList<>());
        }

        // Adding neighbours to each edge
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
