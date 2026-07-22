package com.rv.omaza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalTest {


    @Test
    public void test1() {
        MergeInterval obj = new MergeInterval();
//        obj.solve(new int[][]{{1,3},
//                {2,6},{8, 10},{15,18}});

//        obj.solve(new int[][]{{1,4},
//                {4,5}});

        obj.solve(new int[][]{{4,7},
                {1,4}});
    }
}