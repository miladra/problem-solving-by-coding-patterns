# problem

Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

# idea

- Brute Force Solution:

One way to solve this problem is by traversing the tree from the root node and finding the paths from the root node to the two given nodes. Then, we can compare the paths to find the lowest common ancestor.

To implement this approach, we can use a recursive function that takes in the current node and the two nodes p and q. The function should return a list of nodes representing the path from the current node to either p or q. We can then compare these paths to find the lowest common ancestor.

Time Complexity: O(n^2) in the worst case when the BST is skewed and we have to traverse all n nodes from the root to find the paths to the two nodes p and q.

Space Complexity: O(n) to store the paths to the two nodes.

- Optimal Solution:

A more efficient approach to solve this problem is to use the properties of a BST. Since the left subtree of a node contains only nodes with keys lesser than the node's key, and the right subtree of a node contains only nodes with keys greater than the node's key, we can take advantage of these properties to find the LCA.

We start at the root node, and if both p and q are greater than the current node, we move to the right subtree. If both p and q are less than the current node, we move to the left subtree. If one is greater and one is less than the current node, then we have found the LCA.
Time Complexity: O(h) where h is the height of the tree, and in the worst case, when the tree is skewed, h=n.

Space Complexity: O(1) since we are not using any additional data structures for storing the paths.