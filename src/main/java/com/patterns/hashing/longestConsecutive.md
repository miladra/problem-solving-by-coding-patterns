Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]

Output: 4

Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


# Clarifying questions:
Are the integers in the input array unique or can there be duplicates? (Let's assume unique)
Can the array be empty? (Yes)
Can there be negative numbers in the input? (Yes)

# Approach:

We need to find the longest consecutive streak of numbers in the array.
We can use a HashSet to store all numbers from the input array.
Then for each number, check if the number - 1 exists in the set or not.
If number - 1 doesn't exist, it means this could be the start of a streak.
Then we can keep checking next consecutive numbers till we find the end of the streak.
Keep track of the longest streak found.

Time Complexity: O(N) 
Space Complexity: O(N)