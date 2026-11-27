package com.rv.problems;

import com.rv.entity.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaximumPathSumTest {

    @Test
    public void test1() {
        Tree head = new Tree(1);
        head.left = new Tree(2);
        head.right = new Tree(3);

        MaximumPathSum obj = new MaximumPathSum();
        assertEquals(6, obj.maxSum(head));
    }

    @Test
    public void test2() {
        Tree head = new Tree(-10);
        head.left = new Tree(9);
        head.right = new Tree(20);
        head.right.left = new Tree(15);
        head.right.right = new Tree(7);

        MaximumPathSum obj = new MaximumPathSum();
        assertEquals(42, obj.maxSum(head));
    }

    @Test
    public void test3() {
        Tree head = new Tree(1);
        head.left = new Tree(-2);
        head.right = new Tree(3);

        MaximumPathSum obj = new MaximumPathSum();
        assertEquals(4, obj.maxSum(head));
    }

}