package com.patterns.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWater {

    public int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right){
            int containerLength = right - left;
            int area = containerLength * Math.min(height[left] , height[right]);
            res = Math.max(res , area);
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
    @Test
    public void testMaxArea() {
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected1 = 49;
        int result1 = maxArea(heights1);
        assertEquals(expected1, result1);

        int[] heights2 = {1, 1};
        int expected2 = 1;
        int result2 = maxArea(heights2);
        assertEquals(expected2, result2);

        int[] heights3 = {2, 1};
        int expected3 = 1;
        int result3 = maxArea(heights3);
        assertEquals(expected3, result3);

        int[] heights4 = {0, 0};
        int expected4 = 0;
        int result4 = maxArea(heights4);
        assertEquals(expected4, result4);

        int[] heights5 = {1, 2, 1};
        int expected5 = 2;
        int result5 = maxArea(heights5);
        assertEquals(expected5, result5);

        int[] heights6 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int expected6 = 25;
        int result6 = maxArea(heights6);
        assertEquals(expected6, result6);
    }

}
