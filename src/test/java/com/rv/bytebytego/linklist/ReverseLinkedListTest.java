package com.rv.bytebytego.linklist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseLinkedListTest {

    ReverseLinkedList obj = new ReverseLinkedList();

    @Test
    public void test1(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = obj.solve(head);
        assertEquals(3, head.val);
        assertEquals(2, head.next.val);
        assertEquals(1, head.next.next.val);
    }

    @Test
    public void test2(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = obj.solve(head);
        assertEquals(4, head.val);
        assertEquals(3, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(1, head.next.next.next.val);
    }

    @Test
    public void test3(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = obj.solve1(head);
        assertEquals(3, head.val);
        assertEquals(2, head.next.val);
        assertEquals(1, head.next.next.val);
    }

    @Test
    public void test4(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head = obj.solve1(head);
        assertEquals(4, head.val);
        assertEquals(3, head.next.val);
        assertEquals(2, head.next.next.val);
        assertEquals(1, head.next.next.next.val);
    }
}