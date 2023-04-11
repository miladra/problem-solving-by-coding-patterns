# problem

Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

# idea
- DFS
  The time complexity of the maximumDepthOfBinaryTreeDFS method is O(n),
  where n is the number of nodes in the binary tree. 
  This is because the method traverses the entire tree once, 
  visiting each node exactly once.

  The space complexity of this method is O(h),
  where h is the height of the binary tree. 
  This is because the method uses a recursive approach to traverse the tree,
  which creates a new stack frame for each level of the tree that is visited. 
  The maximum depth of the recursion is equal to the height of the tree, 
  which gives us a space complexity of O(h).
  In the worst case, when the binary tree is skewed, 
  the height of the tree can be equal to the number of nodes, 
  resulting in a space complexity of O(n).

- BFS
  The time complexity of the given method is O(N), where N is the number of nodes in the tree, as each node is visited exactly once.

  The space complexity of the method is O(M), where M is the maximum number of nodes at any level in the tree. In the worst case, when the tree is a complete binary tree, the maximum number of nodes at the deepest level would be (N/2) and thus the space complexity will be O(N/2) which is equivalent to O(N).

  In the best case, when the tree is just a single node, only that node will be stored in the queue, and thus the space complexity will be O(1). Overall, the space complexity of the algorithm depends on the shape of the input tree.