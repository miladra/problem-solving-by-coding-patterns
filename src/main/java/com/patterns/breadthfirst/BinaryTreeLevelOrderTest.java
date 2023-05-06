package com.patterns.breadthfirst;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLevelOrderTest {

    @Test
    public void testLevelOrder2() {
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        // Test case 1: Normal binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );
        assertEquals(expected1, binaryTreeLevelOrder.levelOrder2(root1));
        assertEquals(expected1, binaryTreeLevelOrder.levelOrder(root1));

        // Test case 2: Empty tree
        TreeNode root2 = null;
        List<List<Integer>> expected2 = new ArrayList<>();
        assertEquals(expected2, binaryTreeLevelOrder.levelOrder2(root2));
        assertEquals(expected2, binaryTreeLevelOrder.levelOrder(root2));

        // Test case 3: Tree with one node
        TreeNode root3 = new TreeNode(1);
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected3, binaryTreeLevelOrder.levelOrder2(root3));
        assertEquals(expected3, binaryTreeLevelOrder.levelOrder(root3));
    }
}
