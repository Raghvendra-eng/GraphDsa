package com.rv.bytebytego.linklist;

public class ReverseLinkedList {

    public ListNode solve(ListNode head) {
        return reverse(head, null);
    }

    public ListNode solve1(ListNode head) {
        ListNode curr = head, prev = null, next;
        while(curr!= null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode reverse(ListNode head, ListNode prev) {
        if (head == null ) {
            return prev;
        }
        ListNode revHead = reverse(head.next, head);
        head.next = prev;
        return revHead;
    }
}
