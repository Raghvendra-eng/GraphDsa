package com.rv.bytebytego.hashmap;

//For each zero in an m x n matrix, set its entire row and column to zero in place.
public class ZeroStriping {

    public void solve(int[][] mat) {
        boolean isFirstRowZero = false, isFirstColZero = false;

        for ( int i = 0; i < mat[0].length; i++) {
            if (mat[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for ( int i = 0; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for ( int i = 1; i < mat.length; i++) {
            for ( int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for ( int i = 1; i < mat.length; i++) {
            for ( int j = 1; j < mat[0].length; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        for ( int i = 0; isFirstRowZero && i < mat[0].length; i++) {
            mat[0][i] = 0;
        }

        for ( int i = 0; isFirstColZero && i < mat.length; i++) {
            mat[i][0] = 0;
        }
    }
}
