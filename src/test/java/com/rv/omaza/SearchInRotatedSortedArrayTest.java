package com.rv.omaza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInRotatedSortedArrayTest {


    @Test
    public void test() {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        assertEquals(true, obj.solve(new int[]{2,5,6,0,0,1,2}, 0));
        assertEquals(false, obj.solve(new int[]{2,5,6,0,0,1,2}, 3));
        assertEquals(true, obj.solve(new int[]{2,5,6,0,0,1,2}, 2));
        assertEquals(true, obj.solve(new int[]{2,5,6,0,0,1,2}, 5));
        assertEquals(false, obj.solve(new int[]{2,5,6,0,0,1,2}, 10));
    }
}