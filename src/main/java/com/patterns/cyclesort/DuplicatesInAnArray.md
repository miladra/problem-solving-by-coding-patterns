# problem

Find All Duplicates in an Array

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.

# idea

Questions to clarify the problem:
Can the input array be modified?
Is the order of the output important?
Assuming that the input array can be modified and the order of the output is not important, here is an approach to solve this problem:

Approach:
Since all elements in the array are in the range [1, n], we can use the index of the array to keep track of the elements that have been seen.
For each element in the array, we can negate the value at the index corresponding to that element. If the value at that index is already negative, it means that we have seen this element before and it is a duplicate.

Time and space complexity:
The time complexity of this solution is O(n) since we are iterating over the array once.
The space complexity is O(1) since we are not using any extra space apart from the result list.
