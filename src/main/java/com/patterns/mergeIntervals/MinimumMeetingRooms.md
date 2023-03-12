# problem 

Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.
Example 1:
Input:
[[0,30],[5,10],[15,20]]
Output:
false
Example 2:
Input:
[[7,10],[2,4]]

Output:
true

# idea

The time complexity of the given Java solution is O(n log n), where "n" is the number of meeting intervals because we are sorting the intervals based on start times. The space complexity is O(1) because we are not using any extra space that depends on the size of the input.