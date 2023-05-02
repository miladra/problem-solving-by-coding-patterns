# Problem
Find Right Interval

You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.



Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.


Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start point of each interval is unique.


# Idea
Clarify the problem:
Are the intervals sorted in any way?
Can there be multiple intervals with the same start value?
Can the intervals be empty or have a negative start or end value?

Approach: We can use two heaps to solve this problem. One min heap to store the start values of the intervals and another min heap to store the end values of the intervals. We also need a HashMap to store the index of each interval in the input array.
First, we add all the intervals to both heaps and the HashMap. Then, we iterate through the end values heap and for each end value, we check if there is a start value in the start values heap that is greater than or equal to it. If there is, we add the index of that interval to our result array. If there isn’t, we add -1 to our result array.


Time complexity: O(nlogn), where n is the number of intervals. 
Space complexity: O(n), where n is the number of intervals.