package com.rv.paytm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Question q = new Question();
    @Test
    public void test() {
        assertEquals(6, q.solve(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10, q.solve(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

}