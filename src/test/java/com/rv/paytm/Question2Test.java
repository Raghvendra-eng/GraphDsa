package com.rv.paytm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question2Test {

    Question2 q = new Question2();

    @Test
    public void test() {
        assertEquals(2, q.solve("1012"));
    }

}