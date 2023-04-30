package com.patterns.depthfirst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreePathTest {
    @Test
    public void testEmptyTree() {
        assertFalse(BinaryTreePath.findPath(null, new int[] { } , 0));
    }

    @Test
    public void testSingleNodeTree() {
        BinaryTreePath.TreeNode node = new BinaryTreePath.TreeNode(1);
        assertTrue(BinaryTreePath.findPath(node, new int[] { 1 } , 0));
        assertFalse(BinaryTreePath.findPath(node, new int[] { 2 } , 0));
    }

    @Test
    public void testMultiNodeTree() {
        BinaryTreePath.TreeNode root = new BinaryTreePath.TreeNode(1);
        root.left = new BinaryTreePath.TreeNode(2);
        root.right = new BinaryTreePath.TreeNode(3);
        root.left.left = new BinaryTreePath.TreeNode(4);
        root.left.right = new BinaryTreePath.TreeNode(5);
        root.right.left = new BinaryTreePath.TreeNode(6);
        root.right.right = new BinaryTreePath.TreeNode(8);

        assertTrue(BinaryTreePath.findPath(root, new int[] { 1, 2, 4 } , 0));
        assertTrue(BinaryTreePath.findPath(root, new int[] { 1, 2, 5 } , 0));
        assertTrue(BinaryTreePath.findPath(root, new int[] { 1, 3, 6 } , 0));
        assertFalse(BinaryTreePath.findPath(root, new int[] { 1, 3, 7 } , 0));
    }

}
