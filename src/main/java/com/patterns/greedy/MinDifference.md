# problem
Minimum Difference Between Largest and Smallest Value in Three Moves

You are given an integer array nums.

In one move, you can choose one element of nums and change it to any value.

Return the minimum difference between the largest and smallest value of nums after performing at most three moves.



Example 1:

Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.
Example 2:

Input: nums = [1,5,0,10,14]
Output: 1
Explanation: We can make at most 3 moves.
In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
After performing 3 moves, the difference between the minimum and maximum is 1 - 0 = 1.
It can be shown that there is no way to make the difference 0 in 3 moves.
Example 3:

Input: nums = [3,100,20]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 100 to 7. nums becomes [4,7,20].
In the second move, change 20 to 7. nums becomes [4,7,7].
In the third move, change 4 to 3. nums becomes [7,7,7].
After performing 3 moves, the difference between the minimum and maximum is 7 - 7 = 0.


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

# idea
Let me clarify a few things about the problem:

Can we change the value of an element to any number? - Yes
Are the elements in the array distinct? - No
To solve this problem, we can try and find the minimum difference between the largest and smallest value of nums after performing at most three moves.

The first step is to sort the array in ascending order so that we know the positions of the maximum and minimum values in the array. We then consider four cases:

If there are fewer than 4 elements in the array, we can change any missing elements to one of the existing elements to get a difference of 0.
If there are exactly 4 elements in the array, we can change any one of them to any value between the current minimum and the current maximum to get a difference of 0.
If there are more than 4 elements in the array, we can try changing one element at a time and compute the difference between the new minimum and the new maximum at each step. We keep track of the minimum difference seen so far and return it as the answer.
If there are more than 7 elements in the array, we can apply the same logic as case 3, but we only need to consider changing 3 numbers since we can leave out one of the minimum or maximum values.

Time complexity: Sorting the array takes O(n log n) time. The loop takes O(1) time since it iterates only 4 times. Therefore, the overall time complexity is O(n log n).
Space complexity: The space complexity is O(1) since we are not using any extra data structures.