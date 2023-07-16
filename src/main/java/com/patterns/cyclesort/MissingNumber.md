# problem

Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.


Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 
# idea

Approach: 
One way to solve this problem is to use the Gauss’ Formula, which states that the sum of the first n natural numbers is n(n+1)/2.
Since we know that the input array contains n distinct numbers in the range [0, n],
we can calculate the expected sum of all numbers in this range using the formula. Then,
we can calculate the actual sum of all numbers in the input array and subtract it from the expected sum to find the missing number.

Time and space complexity:
Time complexity: O(n), where n is the length of the input array, since we need to iterate over all elements in the array to calculate the actual sum. 
Space complexity: O(1), since we only use a constant amount of extra space to store variables.


