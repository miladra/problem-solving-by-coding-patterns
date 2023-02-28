# Problem

Longest Substring with At Most K Distinct Characters

Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

# idea


To solve this problem in Java, we can use the sliding window technique where we maintain a window of characters that contains at most k distinct characters. We will move the window from left to right, and update the maximum length of the substring T whenever we encounter a window with at most k distinct characters.

