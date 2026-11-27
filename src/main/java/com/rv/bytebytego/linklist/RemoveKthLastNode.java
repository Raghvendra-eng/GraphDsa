package com.rv.bytebytego.linklist;

public class RemoveKthLastNode {

    public ListNode solve(ListNode head, int k) {
        ListNode kthNode = head;
        int count = 1;
        while (kthNode != null && count < k) {
            kthNode = kthNode.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode start = head, end = kthNode, prev = null;
        while (end.next != null) {
            prev = start;
            start = start.next;
            end = end.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = start.next;
        return head;
    }
}
