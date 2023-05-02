package com.patterns.twoheap;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class FindRightIntervalTest {

    @Test
    public void findRightIntervalTest() {
        FindRightInterval solution = new FindRightInterval();


        // Test case 1
        int[][] intervals1 = {{1, 2}};
        int[] expectedResult1 = {-1};
        assert Arrays.equals(solution.findRightInterval(intervals1), expectedResult1);

        // Test case 2
        int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
        int[] expectedResult2 = {-1, 0, 1};
        assert Arrays.equals(solution.findRightInterval(intervals2), expectedResult2);

        // Test case 3
        int[][] intervals3 = {{1, 4}, {2, 3}, {3, 4}};
        int[] expectedResult3 = {-1, 2, -1};
        assert Arrays.equals(solution.findRightInterval(intervals3), expectedResult3);
    }
}
