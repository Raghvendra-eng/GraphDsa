package com.rv.problems;

import java.util.*;

public class CountIsland {

    private int[][] island;

    private static final int [][]direction = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    public CountIsland() {
        this.island = new int[][] {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1},
        };
    }

    public int countIsland() {
        Set<List<Integer>> land = new HashSet<>();
        for (int row = 0; row < island.length; row++) {
            for ( int col = 0; col < island[row].length; col++) {
                if (island[row][col] == 1)
                land.add(Arrays.asList(row, col));
            }
        }

        int ans = 0;
        for (int row = 0; row < island.length; row++) {
            for ( int col = 0; col < island[row].length; col++) {
                List<Integer> key = Arrays.asList(row, col);
                if (island[row][col] == 1 && land.contains(key)) {
                    ans++;
                    land.remove(key);
                    dfs(row, col, land);
                }
            }
        }
        return ans;
    }

    private void dfs(int row, int col, Set<List<Integer>> land) {
        for (int[] dir: direction) {
            if(isValid(row+dir[0], col+ dir[1], land)) {
                land.remove(Arrays.asList(row+dir[0], col+ dir[1]));
                dfs(row+dir[0], col+ dir[1], land);
            }
        }
    }

    private boolean isValid(int row, int col, Set<List<Integer>> land) {
       return row >= 0 && row < island.length
               && col >= 0 && col < island[row].length
               && island[row][col] == 1
               && land.contains(Arrays.asList(row, col));
    }
}
