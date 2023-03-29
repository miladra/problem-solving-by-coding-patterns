# problem

Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

# idea

In this solution, we first calculate the length of the linked list and connect its last element to the head to form a circular linked list. Then, we find the new head by traversing the linked list from (len-k+1)th node. After that, we break the circular link by setting the next of (len-k)th node to null. Finally, we return the new head.
This algorithm has a time complexity of O(n) and space complexity of O(1), where n is the length of the linked list.