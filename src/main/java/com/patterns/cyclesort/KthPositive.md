# problem

Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length

# idea

This solution uses a while loop to iterate through the array and keep track of the number of missing positive integers. The variable missingCount keeps track of how many missing positive integers have been found so far. The variable currentNum represents the current positive integer being checked. The variable index keeps track of the position in the array.

Inside the while loop, we first check if currentNum is equal to the element at position index in the array. If it is, we increment index. Otherwise, we increment missingCount. After each iteration of the loop, we increment currentNum.

The loop continues until missingCount is equal to k, meaning that we have found the kth missing positive integer. At this point, we return currentNum - 1, which is the value of the kth missing positive integer.

This solution has a time complexity of O(k + n), where n is the length of the input array.
