package com.patterns.breadthfirst;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }

        if(root.right == null){
            return minDepth(root.left) + 1;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return Math.min(leftDepth , rightDepth) + 1;
    }

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
