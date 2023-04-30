package com.patterns.depthfirst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathSumTest {

    @Test
    public void hasPathSumTest(){
        PathSum pathSum = new PathSum();
        // Test case 1: Tree has a path with sum equal to targetSum
        BinaryTreePath.TreeNode root = new BinaryTreePath.TreeNode(5);
        root.left = new BinaryTreePath.TreeNode(4);
        root.right = new BinaryTreePath.TreeNode(8);

        root.left.left = new BinaryTreePath.TreeNode(11);
        root.left.left.left = new BinaryTreePath.TreeNode(7);
        root.left.left.right = new BinaryTreePath.TreeNode(2);
        root.right.left = new BinaryTreePath.TreeNode(13);
        root.right.right = new BinaryTreePath.TreeNode(4);
        root.right.right.right = new BinaryTreePath.TreeNode(1);
        assertTrue(pathSum.hasPathSum(root, 22));

        // Test case 2: Tree does not have a path with sum equal to targetSum
        assertFalse(pathSum.hasPathSum(root, 21));

        // Test case 3: Null root returns false
        assertFalse(pathSum.hasPathSum(null, 5));

        // Test case 4: Tree has only one node and its value is equal to targetSum
        BinaryTreePath.TreeNode singleNode = new BinaryTreePath.TreeNode(5);
        assertTrue(pathSum.hasPathSum(singleNode, 5));

        // Test case 5: Tree has only one node but its value is not equal to targetSum
        assertFalse(pathSum.hasPathSum(singleNode, 10));
    }
}
