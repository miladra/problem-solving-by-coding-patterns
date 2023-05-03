# Problem

Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

# idea

Can n and k be negative?
What should be returned if n or k is zero?
Can n be less than k?

Approach:
We can solve this problem using backtracking. We start with an empty list and add elements to it until its size becomes equal to k. At each step, we add a number from the range [1, n] that has not already been selected. We continue this process until we have generated all possible combinations.

Time Complexity and Space Complexity:
The time complexity of this solution is O(n choose k) because there are n choose k possible combinations, and we need to generate all of them. The space complexity is also O(n choose k) because that's the size of the output array.



