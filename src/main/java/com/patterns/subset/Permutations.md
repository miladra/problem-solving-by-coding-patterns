# problem

Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

# idea

To clarify the problem:
Is the input array always going to contain distinct integers?
What is the maximum length of the input array?
Is there a specific order in which the permutations should be returned?
Assuming that the input array will always contain distinct integers and there is no specific order in which the permutations should be returned, here’s an approach to solve this problem:

Approach: We can use a recursive backtracking approach to generate all possible permutations of the input array. We start by iterating over each element in the input array and adding it to a temporary
list that represents a single permutation. We then recursively call the function with the remaining elements of the input array and repeat this process until we have generated all possible permutations.

The time complexity of this solution is O(n!) where n is the length of the input array since we are generating all possible permutations. 
The space complexity is O(n) since we are using a temporary list to store a single permutation.

