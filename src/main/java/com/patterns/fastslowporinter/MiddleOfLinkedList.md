# problem

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

# idea

This solution uses the two-pointer approach. We have two pointers slow and fast. The slow pointer moves one step at a time while the fast pointer moves two steps at a time. When the fast pointer reaches the end of the list, the slow pointer will be at the middle of the list.