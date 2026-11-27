package com.rv.bytebytego.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroStripingTest {

    ZeroStriping obj = new ZeroStriping();

    @Test
    public void test(){
        int [][]mat = new int[][] {
                {1,2,3,4,5},
                {6,0,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,0},
        };

        int [][]ans = new int[][] {
                {1,0,3,4,0},
                {0,0,0,0,0},
                {11,0,13,14,0},
                {0,0,0,0,0},
        };

        obj.solve(mat);

        for (int i = 0; i < mat.length; i++) {
            for ( int j = 0; j < mat[0].length; j++)
            assertEquals(ans[i][j], mat[i][j]);
        }
    }

}