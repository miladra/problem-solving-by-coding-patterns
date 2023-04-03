package com.patterns.breadthfirst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PopulatingNextRightPointers {

   public Node connect(Node root) {
       if(root == null){
           return null;
       }

       Node leftMost = root;
       while(leftMost.left != null){
           Node curr = leftMost;
           while (curr != null){

               curr.left.next = curr.right;
               if(curr.next != null){
                   curr.right.next = curr.next.left;
               }
               curr = curr.next;
           }

           leftMost = leftMost.left;
       }
       return root;
   }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            val = val;
            left = left;
            right = right;
            next = next;
        }
    }


    @Test
    public void testEmptyTree() {
        PopulatingNextRightPointers sol = new PopulatingNextRightPointers();
        assertNull(sol.connect(null));
    }

    @Test
    public void testSingleNode() {
        PopulatingNextRightPointers sol = new PopulatingNextRightPointers();
        Node root = new Node(1);
        assertNull(sol.connect(root).next);
    }

    @Test
    public void testFullBinaryTree() {
        PopulatingNextRightPointers sol = new PopulatingNextRightPointers();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node result = sol.connect(root);
        assertEquals(result.next, null);
        assertEquals(result.left.next, result.right);
        assertEquals(result.left.left.next, result.left.right);
        assertEquals(result.left.right.next, result.right.left);
        assertEquals(result.right.left.next, result.right.right);
        assertEquals(result.right.right.next, null);
    }

    @Test
    public void testSkewedBinaryTree() {
        PopulatingNextRightPointers sol = new PopulatingNextRightPointers();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        Node result = sol.connect(root);
        assertEquals(result.next, null);
        assertEquals(result.left.next, null);
        assertEquals(result.left.left.next, null);
        assertEquals(result.left.left.left.next, null);
    }
}
