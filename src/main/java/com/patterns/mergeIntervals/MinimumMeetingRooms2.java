package com.patterns.mergeIntervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MinimumMeetingRooms2 {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0){
            return 0;
        }

        int len = intervals.size();
        int[] startTime = new int[len];
        int[] endTime = new int[len];

        for(int i=0; i < len ; i++){
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int res =0;
        int count = 0;
        int s = 0;
        int e = 0;

        while(s< len){
            if(startTime[s] < endTime[e]){
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res= Math.max(res , count);
        }

        return res;
    }

    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    @Test
    public void testMinMeetingRooms() {
        MinimumMeetingRooms2 m = new MinimumMeetingRooms2();

        // Test case with non-overlapping intervals
        List<MinimumMeetingRooms2.Interval> intervals1 = Arrays.asList(
                new MinimumMeetingRooms2.Interval(1, 3),
                new MinimumMeetingRooms2.Interval(4, 6),
                new MinimumMeetingRooms2.Interval(7, 9)
        );
        Assertions.assertEquals(1, m.minMeetingRooms(intervals1));

        // Test case with overlapping intervals
        List<MinimumMeetingRooms2.Interval> intervals2 = Arrays.asList(
                new MinimumMeetingRooms2.Interval(1, 5),
                new MinimumMeetingRooms2.Interval(2, 6),
                new MinimumMeetingRooms2.Interval(3, 7)
        );
        Assertions.assertEquals(3, m.minMeetingRooms(intervals2));

        // Test case with empty list of intervals
        List<MinimumMeetingRooms2.Interval> intervals3 = Arrays.asList();
        Assertions.assertEquals(0, m.minMeetingRooms(intervals3));
    }

}