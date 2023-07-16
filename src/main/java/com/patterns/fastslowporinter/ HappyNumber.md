# problem

Happy Number

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
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

# idea

1) Can we assume that the input number n will always be a positive integer?
2) Can we use additional data structures or should the solution be based on mathematical calculations?
3) Is there any upper limit on the number of iterations to determine if a number is happy or not?

Approach:

To determine if a number is happy, we can follow the given process:
Starting with the given positive integer n, calculate the sum of the squares of its digits.
Repeat the process until the number equals 1 or we encounter a cycle.
If the number equals 1, it is a happy number; otherwise, it is not.

To detect cycles, we can use the Floyd's cycle-finding algorithm, also known as the "tortoise and hare" algorithm. This algorithm involves two pointers: a slow pointer that moves one step at a time and a fast pointer that moves two steps at a time. If there is a cycle, the fast pointer will eventually catch up to the slow pointer.

Time Complexity and Space Complexity:
The time complexity of this solution is difficult to determine precisely since it depends on the number of iterations
required to reach the cycle or to determine that the number is happy. 
In the worst case, where n is not a happy number, the time complexity is considered to be O(log n) 
because the number of digits in n contributes to the number of iterations. 
However, in practice, the algorithm tends to terminate relatively quickly for most inputs,
so it is considered efficient.

The space complexity of the solution is O(1) because we only use a constant amount of extra space to store 
the slow and fast pointers.