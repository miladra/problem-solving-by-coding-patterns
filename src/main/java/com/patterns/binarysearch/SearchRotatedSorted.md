# problem
Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

# idea

Can we assume the array is always sorted in ascending order before rotation?
Can there be duplicates in the given array?
What should be the output if the target element occurs multiple times in the array?

Approach:
The idea is to use binary search to find the target element in the rotated sorted array. We start by finding the pivot element (the smallest element in the array). Once we have found the pivot, we can divide the array into two parts, both of which are sorted in ascending order. Then, we can perform a binary search on either the left or right subarray depending on whether the target element lies within the range of the left or right subarray. If we find the target element, we return its index, else we return -1.
The time complexity of this algorithm is O(log n) because we are dividing the search space in half in each iteration.


Time complexity and space complexity:
The time complexity of this algorithm is O(log n) since we are performing binary search twice, once to find the pivot and once to find the target element. 
The space complexity is O(1) since we are not using any extra space apart from a few variables.

