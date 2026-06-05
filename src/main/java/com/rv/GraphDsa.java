package com.rv;

import com.rv.traversals.BFS;
import com.rv.traversals.DFS;
import com.rv.representation.AdjacencyList;

import java.util.List;

public class GraphDsa {

    public static void main(String []args) {
        int [][]edges = new int[][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {4, 5},
        };
        List<List<Integer>> graph = AdjacencyList.createUndirectedAdjacencyList(edges, 6);
        DFS dfsObj = new DFS();
        dfsObj.dfsTraversal(graph, 0);

        System.out.println();

        BFS bfsObj = new BFS();
        bfsObj.bfsTraversal(graph, 0);


    }
}
