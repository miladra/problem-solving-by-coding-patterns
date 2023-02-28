# Problem

Longest Substring with At Most Two Distinct Characters

Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: tis "ece" which its length is 3.

Example 2:

Input: "ccaabbb"
Output: 5
Explanation: tis "aabbb" which its length is 5.


# Idea

To solve this problem in Java, we can use the sliding window technique. We can maintain a window of characters that contains at most 2 distinct characters and keep track of the maximum length of such a window.