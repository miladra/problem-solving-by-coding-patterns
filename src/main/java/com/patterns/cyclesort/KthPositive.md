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

Questions to clarify the problem:
Can the array contain duplicate elements?
Is it guaranteed that the array is sorted in strictly increasing order?
Is it guaranteed that all elements in the array are positive integers?

Approach:
This solution uses a while loop to iterate over all positive integers until we find the kth missing positive integer.
We use a variable missingCount to keep track of how many missing positive integers we have encountered so far.
We also use a variable currentNumber to keep track of the current positive integer we are checking.
Finally, we use a variable index to keep track of our position in the input array.

Inside the while loop, we first check if currentNumber is missing from the input array by checking if it is equal to the current element in the array pointed to by index. If it is not missing, we move index to the next element in the array. If it is missing, we increment missingCount.
Then, we move to the next positive integer by incrementing currentNumber.

Time and space complexity:
The time complexity of this solution is O(k), where k is the input parameter.
This is because we need to iterate over all positive integers until we find the kth missing positive integer.
The space complexity of this solution is O(1), since we only use a constant number of variables.