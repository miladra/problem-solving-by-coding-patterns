# problem

Happy Number
Easy
8.2K
1K
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

# idea

The solution uses the slow and fast pointer approach to detect cycles. 
The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
If there’s a cycle in the process, the two pointers will eventually meet.
If they meet and the value of fast is not 1, it means that the number is not happy. 
This solution has a time complexity of O(log n) but its space complexity is O(1) because it doesn’t need to store any additional data.