# Problem
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

# idea

Clarifying questions:
Can we assume that the binary tree is not empty?
Are the numbers in the sequence unique?
Can we modify the binary tree?
Approach:
We can solve the problem recursively by traversing the binary tree from the root to the leaf nodes. At each node, we check if the current node corresponds to the next number in the sequence. If it does, we continue searching for the next number in the left and right subtrees of the current node. If we reach a leaf node and the sequence has been completely traversed, we return true. Otherwise, we return false.

Time complexity: The time complexity of the solution is O(N), where N is the total number of nodes in the binary tree. This is because we traverse every node once.
Space complexity: The space complexity of the solution is O(H), where H is the height of the binary tree. This is because the recursive call stack can go as deep as the height of the tree.