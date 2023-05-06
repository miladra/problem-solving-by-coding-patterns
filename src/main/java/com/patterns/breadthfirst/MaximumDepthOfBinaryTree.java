package com.patterns.breadthfirst;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTree {
    //DFS
    public int maximumDepthOfBinaryTreeDFS(TreeNode root){

        if(root == null){
            return 0;
        } else if(root.left == null && root.right == null){
            return 1;
        } else{
           return  1 + Math.max(maximumDepthOfBinaryTreeDFS(root.left) , maximumDepthOfBinaryTreeDFS(root.right));
        }
    }

    //BFS
    public int maximumDepthOfBinaryTreeBFS(TreeNode root){

        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currDepth = 0;
        while(!queue.isEmpty()){
            currDepth++;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode treeNode =  queue.remove();

                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
        }

        return currDepth;
    }

    @Test
    public void testMaximumDepthOfBinaryTreeDFS() {
        TreeNode leaf1 = new TreeNode(4,null, null);
        TreeNode leaf2 = new TreeNode(3,null, null);
        TreeNode node2 = new TreeNode(2,leaf1, null);
        TreeNode root = new TreeNode(1,node2, leaf2);

        int expected = 3;
        int actual = maximumDepthOfBinaryTreeDFS(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeDFSWithNullRoot() {
        int expected = 0;
        int actual = maximumDepthOfBinaryTreeDFS(null);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeDFSWithSingleNode() {
        TreeNode root = new TreeNode(1,null, null);

        int expected = 1;
        int actual = maximumDepthOfBinaryTreeDFS(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeBFS() {
        // create a binary tree of depth 3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int expectedDepth = 3;
        int actualDepth = maximumDepthOfBinaryTreeBFS(root);

        assertEquals(expectedDepth, actualDepth);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeBFSWithNullRoot() {
        int expectedDepth = 0;
        int actualDepth = maximumDepthOfBinaryTreeBFS(null);

        assertEquals(expectedDepth, actualDepth);
    }

    @Test
    public void testMaximumDepthOfBinaryTreeBFSWithSingleNodeTree() {
        TreeNode root = new TreeNode(1);

        int expectedDepth = 1;
        int actualDepth = maximumDepthOfBinaryTreeBFS(root);

        assertEquals(expectedDepth, actualDepth);
    }
}

