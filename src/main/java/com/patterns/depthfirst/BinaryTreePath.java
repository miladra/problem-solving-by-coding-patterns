package com.patterns.depthfirst;

public class BinaryTreePath {
        public static boolean findPath(TreeNode node, int[] sequence, int index) {
            // if the node is null or the value does not match the current element in the sequence
            if (node == null || node.value != sequence[index]) {
                return false;
            }

            // if we have reached the last element in the sequence and it matches the node value
            if (index == sequence.length - 1 && node.value == sequence[index]) {
                return true;
            }

            // recursively search in left and right subtrees
            return findPath(node.left, sequence, index + 1) || findPath(node.right, sequence, index + 1);
        }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
