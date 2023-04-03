package com.patterns.breadthfirst;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeLevelOrder {
        public List<List<Integer>> levelOrder2(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();

            if(root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int cnt = queue.size();
                for(int i= 0; i < cnt; i++){

                    TreeNode node = queue.poll();
                    level.add(node.val);

                    if(node.left != null) queue.add(node.left);

                    if(node.right != null) queue.add(node.right);

                }

                res.add(level);
            }

            return res;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> result = new ArrayList<List<Integer>>();

            if (root == null) {
                return result;
            }

            // @note: use level count as marker of each level, instead of adding an extra null as marker
            int currentLevelCount = 0;
            int nextLevelCount = 0;

            // initialization
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.offer(root);
            currentLevelCount++;

            List<Integer> currentLevelList = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode currentNode = q.poll();
                currentLevelCount--;

                currentLevelList.add(currentNode.val);

                // enqueue
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                    nextLevelCount++;
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                    nextLevelCount++;
                }

                // check if end of current level
                if (currentLevelCount == 0) {
                    currentLevelCount = nextLevelCount;
                    nextLevelCount = 0;

                    // add this level int list to result
                    result.add(new ArrayList<>(currentLevelList));
                    currentLevelList.clear();
                }
            }

            return result;
        }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    @Test
    public void testLevelOrder2() {
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
        assertEquals(expected1, levelOrder2(root1));
        assertEquals(expected1, levelOrder(root1));

        // Test case 2: Empty tree
        TreeNode root2 = null;
        List<List<Integer>> expected2 = new ArrayList<>();
        assertEquals(expected2, levelOrder2(root2));
        assertEquals(expected2, levelOrder(root2));

        // Test case 3: Tree with one node
        TreeNode root3 = new TreeNode(1);
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1)
        );
        assertEquals(expected3, levelOrder2(root3));
        assertEquals(expected3, levelOrder(root3));
    }
}
