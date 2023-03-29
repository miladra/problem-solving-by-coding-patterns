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

We first check whether the given linked list is empty or contains only one element or k=0. If any of these conditions are satisfied, we return the head as it is because rotation is not possible in these cases.

Then, we find the length of the linked list and adjust the value of k by taking its modulus with the length of the linked list. This is because if k is greater than the length of the linked list, it will cause unnecessary rotations.

After that, we find the new tail and head of the linked list after rotating it k times to the right. We do this by traversing the linked list from the head until len-k-1th node to get the new tail and finding the next node of the new tail to get a new head.

Finally, we rotate the linked list by setting the next of the original tail to the head and the next of the new tail to null. We return the new head as the result.

This algorithm has a time complexity of O(n) and space complexity of O(1), where n is the length of the linked list.