package com.patterns.cyclesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int total = nums.length * ( nums.length + 1 ) / 2;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return total - sum;
    }

    @Test
    public void testMissingNumber() {
        int[] nums1 = {3, 0, 1};
        assertEquals(2, missingNumber(nums1));

        int[] nums2 = {0, 1};
        assertEquals(2, missingNumber(nums2));

        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assertEquals(8, missingNumber(nums3));
    }
}
