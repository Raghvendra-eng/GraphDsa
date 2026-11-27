package com.rv.bytebytego.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeometricSequenceTripletsTest {
    GeometricSequenceTriplets obj = new GeometricSequenceTriplets();
    @Test
    void test() {
        assertEquals(5, obj.solve(new int[]{2, 1, 2, 4, 8, 8}, 2));
    }
}