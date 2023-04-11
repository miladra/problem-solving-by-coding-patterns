package com.patterns.breadthfirst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root , TreeNode p , TreeNode q){
        List<TreeNode> path1 = findPath(root , p);
        List<TreeNode> path2 = findPath(root , q);

        int i=0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }

        return path1.get(i - 1);

    }

    private List<TreeNode> findPath(TreeNode root , TreeNode node){
        List<TreeNode> path = new ArrayList<>();
        if(root == null){
            return path;
        }

        if(root.val == node.val){
            path.add(root);
            return path;
        }

        path.add(root);
        if (root.val > node.val) {
            path.addAll(findPath(root.left, node));
        } else {
            path.addAll(findPath(root.right, node));
        }
        return path;
    }

    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else{
            return root;
        }

    }

    //Time Complexity: O(h) where h is the height of the tree, and in the worst case, when the tree is skewed, h=n.
    //Space Complexity: O(1) since we are not using any additional data structures for storing the paths.
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }

    @Test
    void lowestCommonAncestor() {
        LowestCommonAncestor.TreeNode root = new LowestCommonAncestor.TreeNode(6);
        root.left = new LowestCommonAncestor.TreeNode(2);
        root.right = new LowestCommonAncestor.TreeNode(8);
        root.left.left = new LowestCommonAncestor.TreeNode(0);
        root.left.right = new LowestCommonAncestor.TreeNode(4);
        root.right.left = new LowestCommonAncestor.TreeNode(7);
        root.right.right = new LowestCommonAncestor.TreeNode(9);
        root.left.right.left = new LowestCommonAncestor.TreeNode(3);
        root.left.right.right = new LowestCommonAncestor.TreeNode(5);

        LowestCommonAncestor lca = new LowestCommonAncestor();

        Assertions.assertEquals(root, lca.lowestCommonAncestor(root, root.left, root.right));
        Assertions.assertEquals(root.left, lca.lowestCommonAncestor(root, root.left, root.left.right));
        Assertions.assertEquals(root.left, lca.lowestCommonAncestor(root, root.left.left, root.left.right.left));
        Assertions.assertEquals(root.left.right, lca.lowestCommonAncestor(root, root.left.right.left, root.left.right.right));
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
