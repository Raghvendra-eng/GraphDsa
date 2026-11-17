package com.rv.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInSortedRotatedArrayTest {

    SearchInSortedRotatedArray obj = new SearchInSortedRotatedArray();

    @Test
    public void test() {
        Assertions.assertEquals( 4, obj.search(new int[]{4,5,6,7,0,1,2}, 0));

        Assertions.assertEquals( -1, obj.search(new int[]{4,5,6,7,0,1,2}, 3));

        Assertions.assertEquals( -1, obj.search(new int[]{1}, 0));
    }

}