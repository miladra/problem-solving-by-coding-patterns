package com.patterns.fastslowporinter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

      public class ListNode {
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

    @Test
    public void testMiddleNode_oddLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode middleNode = solution.middleNode(head);

        assertEquals(3, middleNode.val);
        assertEquals(4, middleNode.next.val);
        assertEquals(5, middleNode.next.next.val);
        assertNull(middleNode.next.next.next);
    }

    @Test
    public void testMiddleNode_evenLength() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode middleNode = solution.middleNode(head);

        assertEquals(4, middleNode.val);
        assertEquals(5, middleNode.next.val);
        assertEquals(6, middleNode.next.next.val);
        assertNull(middleNode.next.next.next);
    }
}

