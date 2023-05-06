package com.patterns.breadthfirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
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
}
