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

The algorithm starts by initializing an empty result list. Then it iterates through each element in the input array. For each element, it calculates an index by taking the absolute value of the current element and subtracting 1. This is because the values in the input array are in the range [1,n], but array indices start from 0.

Next, it checks if the value at that calculated index is negative. If it is, it means that we have seen this value before and should add it to our result list. The value added to the result list is calculated by taking the absolute value of index+1. This reverses our earlier calculation of index and gives us back our original value.

Finally, we negate the value at that calculated index to mark it as seen. This way, if we encounter this same value again later on in our iteration through the input array, we will know that we have seen it before because its corresponding index will be negative.

This algorithm runs in O(n) time because we only iterate through each element in