package com.patterns.inplacereversal;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Get the length of the linked list
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // Adjust the value of k
        k %= len;
        if (k == 0) return head;

        // Find the new tail and head
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Rotate the list
        tail.next = head;
        newTail.next = null;

        return newHead;
    }
    @Test
    public void testRotateRight() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RotateRight solution = new RotateRight();
        ListNode result = solution.rotateRight(node1, 2);

        assertEquals(result.val, 4);
        assertEquals(result.next.val, 5);
        assertEquals(result.next.next.val, 1);
        assertEquals(result.next.next.next.val, 2);
        assertEquals(result.next.next.next.next.val, 3);
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
