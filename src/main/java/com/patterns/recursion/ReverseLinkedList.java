package com.patterns.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseLinkedList {
    //O(n)
    //O(n)
    public ListNode reverseListRecursively(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode newHead = head;

        if(head.next != null){
            newHead = reverseListRecursively(head.next);
            head.next.next = head;
        }
        head.next = null;

        return newHead;

    }

    //O(n)
    //O(1)
    public ListNode reverseListIteratively(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;

    }

    @Test
    public void testReverseListRecursively_NullInput() {
        assertNull(reverseListRecursively(null));
    }

    @Test
    public void testReverseListRecursively_SingleNode() {
        ListNode head = new ListNode(1);
        ListNode reversedHead = reverseListRecursively(head);

        assertNotNull(reversedHead);
        assertEquals(head, reversedHead);
    }

    @Test
    public void testReverseListRecursively_TwoNodes() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversedHead = reverseListRecursively(node1);

        assertNotNull(reversedHead);
        assertEquals(node2, reversedHead);
        assertEquals(node1, reversedHead.next);
    }

    @Test
    public void testReverseListRecursively_MultipleNodes() {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversedHead = reverseListRecursively(node1);

        assertNotNull(reversedHead);
        assertEquals(node4, reversedHead);
        assertEquals(node3, reversedHead.next);
        assertEquals(node2, reversedHead.next.next);
        assertEquals(node1, reversedHead.next.next.next);
    }

}
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }