# problem

Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

# idae

To solve this problem, we can use the Dutch National Flag algorithm, also known as 3-way partitioning. This algorithm is used to sort an array of 0s, 1s, and 2s. We can adapt it to sort an array of colors by mapping the colors to 0, 1, and 2.

The algorithm consists of three pointers:

The low pointer points to the beginning of the array.
The high pointer points to the end of the array.
The mid pointer starts from the beginning of the array and moves towards the end.
We will iterate through the array with the mid pointer, and if we encounter a 0, we swap it with the element at the low pointer and move both pointers to the right. If we encounter a 2, we swap it with the element at the high pointer and move the high pointer to the left. If we encounter a 1, we just move the mid pointer to the right.

This way, we will ensure that all 0s are at the beginning of the array, all 2s are at the end of the array, and all 1s are in the middle of the array.

This algorithm has a time complexity of O(n) and a space complexity of O(1), which makes it very efficient.