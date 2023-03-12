package com.patterns.mergeIntervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumMeetingRooms {
    public boolean canAttendAllMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start time

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) { // overlapping meetings
                return false;
            }
        }

        return true;
    }

    @Test
    void testCanAttendAllMeetingsReturnsTrueForNonOverlappingIntervals() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        MinimumMeetingRooms scheduler = new MinimumMeetingRooms();
        boolean result = scheduler.canAttendAllMeetings(intervals);
        Assertions.assertTrue(result);
    }

    @Test
    void testCanAttendAllMeetingsReturnsFalseForOverlappingIntervals() {
        int[][] intervals = {{1, 5}, {3, 7}, {6, 8}};
        MinimumMeetingRooms scheduler = new MinimumMeetingRooms();
        boolean result = scheduler.canAttendAllMeetings(intervals);
        Assertions.assertFalse(result);
    }

    @Test
    void testCanAttendAllMeetingsReturnsTrueForSingleInterval() {
        int[][] intervals = {{1, 2}};
        MinimumMeetingRooms scheduler = new MinimumMeetingRooms();
        boolean result = scheduler.canAttendAllMeetings(intervals);
        Assertions.assertTrue(result);
    }

}
