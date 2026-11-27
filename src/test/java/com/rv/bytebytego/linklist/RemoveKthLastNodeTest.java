package com.rv.bytebytego.linklist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveKthLastNodeTest {
    RemoveKthLastNode obj = new RemoveKthLastNode();
    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(3);
        int nums[] = new int[] {1, 2, 4, 3};
        ListNode head2 = obj.solve(head, 2);
        int i = 0;
        ListNode itr = head2;
        for (; itr != null && i < nums.length; itr = itr.next) {
            assertEquals(itr.val, nums[i++]);
        }
        assertNull(itr);
        assertEquals(nums.length, i);
    }
}