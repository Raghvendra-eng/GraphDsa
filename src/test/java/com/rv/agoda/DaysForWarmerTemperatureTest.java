package com.rv.agoda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DaysForWarmerTemperatureTest {

    DaysForWarmerTemperature obj = new DaysForWarmerTemperature();

//    Input: temperatures = [73,74,75,71,69,72,76,73]
//    Output: [1,1,4,2,1,1,0,0]

    @Test
    public void test() {
        int []expected = new int[]{1,1,4,2,1,1,0,0};
        int []output = obj.solve(new int[]{73,74,75,71,69,72,76,73});
        assertEquals(expected.length, output.length);
        assertTrue(Arrays.equals(expected, output));
    }

//    Input: temperatures = [30,40,50,60]
//    Output: [1,1,1,0]

    @Test
    public void test1() {
        int []expected = new int[]{1,1,1,0};
        int []output = obj.solve(new int[]{30,40,50,60});
        assertEquals(expected.length, output.length);
        assertTrue(Arrays.equals(expected, output));
    }
//
//    Input: temperatures = [60,50,40,30]
//    Output: [0,0,0,0]
//
    @Test
    public void test2() {
        int []expected = new int[]{0,0,0,0};
        int []output = obj.solve(new int[]{60,50,40,30});
        assertEquals(expected.length, output.length);
        assertTrue(Arrays.equals(expected, output));
    }

//    Input: temperatures = [73]
//    Output: [0]

    @Test
    public void test3() {
        int []expected = new int[]{0};
        int []output = obj.solve(new int[]{73});
        assertEquals(expected.length, output.length);
        assertTrue(Arrays.equals(expected, output));
    }

//    Input: temperatures = [70,70,71]
//    Output: [2,1,0]

    @Test
    public void test4() {
        int []expected = new int[]{2,1,0};
        int []output = obj.solve(new int[]{70,70,71});
        assertEquals(expected.length, output.length);
        assertTrue(Arrays.equals(expected, output));
    }

}