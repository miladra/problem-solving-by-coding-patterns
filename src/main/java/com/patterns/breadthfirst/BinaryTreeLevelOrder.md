# problem

Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

# idea
Can the binary tree have duplicate values?
What should be returned if the input binary tree is null or empty?
Should we return the level order traversal in a list of lists structure?
The approach to solve this problem would be to perform a Breadth First Search (BFS) traversal on the given Binary Tree and keep track of the current level of the node being visited. We can use a Queue data structure to maintain a list of nodes we need to visit next.

We start by adding the root node to the Queue and traverse the Binary Tree level by level.
At each level, we keep track of the number of nodes present at that level,
which will be equal to the size of the Queue.
We then loop over all the nodes at that level and add their values to a temporary list.
After we finish processing the nodes in that level,
we add the temporary list to our final result list.

Time Complexity:
The time complexity of this solution is O(n), where n is the total number of nodes in the given Binary Tree. This is because we visit each node exactly once during the BFS traversal.

Space Complexity:
The space complexity of this solution is O(n), where n is the total number of nodes in the given Binary Tree. This is because in the worst case scenario, the Queue will contain all the nodes at the lowest level of the Binary Tree.



