# problem 

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei),
find the minimum number of conference rooms required.
Example 1:
Input:
[[0, 30],[5, 10],[15, 20]]
Output:
2
Example 2:
Input:
[[7,10],[2,4]]

Output:
1

# idea

The time complexity of the minMeetingRooms algorithm in this Java code is O(n log n), where 'n' is the number of meetings or time intervals. This is due to the use of sorting two integer arrays of size 'n' using the Java built-in Arrays.sort() function. The while loop that iterates over the sorted starting and ending times is executed up to 'n' times, which does not increase the time complexity over the sorting operation.

The space complexity of the algorithm is O(n) because of the two integer arrays of length 'n' that are created to store the start and end times of the meetings. Additionally, there are some constant space requirements for other variables like res, count, s, and e. However, the space required for these variables is almost negligible compared to the input size and does not significantly affect the overall space complexity.