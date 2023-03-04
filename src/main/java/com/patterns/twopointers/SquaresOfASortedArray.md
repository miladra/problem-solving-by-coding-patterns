# problem

Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

# idea

We will use two pointers to traverse the array from left and right ends towards the center. Since the array is sorted in non-decreasing order, the largest elements will be at the ends of the array. Therefore, we will start by squaring the largest element, and move towards the center of the array.

Time complexity is O(n)
Space complexity is O(1)