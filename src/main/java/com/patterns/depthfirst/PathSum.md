# Problem 

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.


# Idea

Clarifying questions:
Can the binary tree have duplicate values?
Can the values in the binary tree be negative?
Is the binary tree guaranteed to be non-empty?
Are the values in the tree integers or can they be floating-point numbers also?
What should be the return value if the root is null?

Approach:
We can traverse the tree in a depth-first manner, keeping track of the current sum of the path from root to the current node. If we encounter a leaf node, we check if the current sum equals the target sum. If it does, we return true, else we continue the traversal. We can implement this using recursion.

Time complexity: The time complexity of the algorithm is O(n), where n is the number of nodes in the tree. This is because we visit each node once during the traversal.
Space complexity:
The space complexity of the algorithm is O(h), where h is the height of the tree. This is because the maximum number of recursive calls on the call stack at any point in time is equal to the height of the tree.