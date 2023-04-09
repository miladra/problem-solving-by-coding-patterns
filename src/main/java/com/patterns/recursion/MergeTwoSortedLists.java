package com.patterns.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeTwoSortedLists {
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2){

        ListNode head = new ListNode(0);
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        head.next = mergeTwoListsRecursion(l1 , l2);
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

      ListNode head = new ListNode();
      ListNode tail = head;

      while(l1 != null || l2 != null){
          if(l2 == null || (l1 != null && l1.val < l2.val)){
              tail.next = l1;
              tail = l1;
              l1 = l1.next;
          } else {
              tail.next = l2;
              tail = l2;
              l2 = l2.next;
          }
      }

      return head.next;
    }

    @Test
    public void testMergeTwoListsRecursion() {
        // Test case 1: both input lists are null
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode result = mergeTwoListsRecursion(l1, l2);
        assertNull(result);

        // Test case 2: one input list is null
        l1 = null;
        l2 = new ListNode(1);
        result = mergeTwoListsRecursion(l1, l2);
        assertEquals(result, l2);

        // Test case 3: both input lists have one element
        l1 = new ListNode(1);
        l2 = new ListNode(2);
        result = mergeTwoListsRecursion(l1, l2);
        assertEquals(result.val, 1);
        assertEquals(result.next, l2);

        // Test case 4: one input list has one element and the other has multiple elements
        l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l2 = new ListNode(2);
        result = mergeTwoListsRecursion(l1, l2);
        assertEquals(result.val, 1);
        assertEquals(result.next.val, 2);
        assertEquals(result.next.next.val, 3);

        // Test case 5: both input lists have multiple elements and are already sorted
        l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l2 = new ListNode(2);
        l2.next = new ListNode(4);
        result = mergeTwoListsRecursion(l1, l2);
        assertEquals(result.val, 1);
        assertEquals(result.next.val, 2);
        assertEquals(result.next.next.val, 3);
        assertEquals(result.next.next.next.val, 4);

        // Test case 6: both input lists have multiple elements and are not sorted
        l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l2 = new ListNode(2);
        l2.next = new ListNode(4);
        result = mergeTwoListsRecursion(l1, l2);
        assertEquals(result.val, 1);
        assertEquals(result.next.val, 2);
        assertEquals(result.next.next.val, 3);
        assertEquals(result.next.next.next.val, 4);
    }

    class ListNode{
        int val;
        ListNode next;

        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode listNode){
            this.val = val;
            this.next = listNode;
        }
    }
}

