package com.patterns.depthfirst;

public class PathSum {
    public boolean hasPathSum(BinaryTreePath.TreeNode root , int targetSum){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && targetSum - root.value == 0){
            return true;
        }

        return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right , targetSum - root.value);
    }
}
