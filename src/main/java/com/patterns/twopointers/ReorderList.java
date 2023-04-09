package com.patterns.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderList {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        //Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }


    }

    @Test
    public void testReorderList() {
        // Test case 1: empty list
        ListNode head1 = null;
        reorderList(head1);
        assertEquals(null, head1);

        // Test case 2: list with one element
        ListNode head2 = new ListNode(1);
        reorderList(head2);
        assertEquals(1, head2.val);

        // Test case 3: list with two elements
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        reorderList(head3);
        assertEquals(1, head3.val);
        assertEquals(2, head3.next.val);

        // Test case 4: list with three elements
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        reorderList(head4);
        assertEquals(1, head4.val);
        assertEquals(3, head4.next.val);
        assertEquals(2, head4.next.next.val);

        // Test case 5: list with even number of elements
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);
        head5.next.next.next = new ListNode(4);
        reorderList(head5);
        assertEquals(1, head5.val);
        assertEquals(4, head5.next.val);
        assertEquals(2, head5.next.next.val);
        assertEquals(3, head5.next.next.next.val);

        // Test case 6: list with odd number of elements
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);
        head6.next.next.next = new ListNode(4);
        head6.next.next.next.next = new ListNode(5);
        reorderList(head6);
        assertEquals(1, head6.val);
        assertEquals(5, head6.next.val);
        assertEquals(2, head6.next.next.val);
        assertEquals(4, head6.next.next.next.val);
        assertEquals(3, head6.next.next.next.next.val);

        // Test case 7: list with all the same elements
        ListNode head7 = new ListNode(1);
        head7.next = new ListNode(1);
        head7.next.next = new ListNode(1);
        reorderList(head7);
        assertEquals(1, head7.val);
        assertEquals(1, head7.next.val);
        assertEquals(1, head7.next.next.val);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
