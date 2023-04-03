# problem

Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
int val;
Node *left;
Node *right;
Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Example 1:


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000

# idea


The basic idea is to use two nested loops to traverse the tree level by level. 
The outer loop starts from the root and goes down to the last level,
and the inner loop goes across the nodes on each level.
For each node, we set its left child's next pointer to its right child,
and its right child's next pointer to its next node's left child 
(if the next node exists). 
Finally, we move on to the next node on the same level until we reach the end of the level.

The time complexity of this solution is O(n), where n is the number of nodes in the tree, because we visit each node once. 
The space complexity is O(1), because we only use constant extra space to store pointers.